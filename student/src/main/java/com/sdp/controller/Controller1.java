package com.sdp.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.sdp.dao.FileService;
import com.sdp.dao.JobApplicationsRepo;
import com.sdp.dao.StudentRepo;
import com.sdp.entity.GetAppliedStudents;
import com.sdp.entity.GetJobOffers;
import com.sdp.entity.JobApplications;
import com.sdp.entity.JobOffers;
import com.sdp.entity.Student;
import com.sdp.services.AWSS3Service;
import com.sdp.services.Main;

import net.bytebuddy.utility.RandomString;

@RestController
public class Controller1 implements ErrorController,FileService{
	@Autowired
	Main main = new Main();
	@Autowired
	StudentRepo repo;

	@Autowired
	HttpSession session;
	@Autowired
	JobApplicationsRepo applicationRepo;
	String username = null, id = null;
	
//	@Autowired
//    private PasswordEncoder passwordEncoder;
     
    @Autowired
    private JavaMailSender mailSender;
   
    @Autowired
    private AWSS3Service awsS3Service;
    
    @ResponseBody
    @PostMapping("/upload123")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) {
    	System.out.println("hello");
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("upload.jsp");
      awsS3Service.uploadFile(file);
      return mv;
    }
	@GetMapping("/getAppliedStudents/{jobID}")
	public GetAppliedStudents getAppliedStudentsForJob(@PathVariable("jobID") long jobid) {
		List<JobApplications> j = main.getAppliedStudentsForJob(jobid);
		List<Student> studentData = repo.findAll();
		List<Student> applieddata = new ArrayList<Student>();
		for (JobApplications ap : j) {
			String temp = ap.getUserID();
			for (Student s : studentData) {
				
				if (temp.equals(s.getUserID())) {
					applieddata.add(s);
				}
			}
		}

		GetAppliedStudents g = new GetAppliedStudents();
		g.setL(applieddata);
		return g;
	}

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView m = new ModelAndView();

		m.setViewName("main.jsp");
		return m;
	}

	@RequestMapping("studentreg")
	public ModelAndView addStudent(Student s,HttpServletRequest req) throws UnsupportedEncodingException, MessagingException{
		ModelAndView m = new ModelAndView();
//		String encodedPassword = passwordEncoder.encode(s.getPassword());
//	    s.setPassword(encodedPassword);
		
	    String randomCode = RandomString.make(64);
	    s.setVerificationCode(randomCode);
	    s.setEnabled(false);
		repo.save(s);
		sendVerificationEmail(s, getSiteURL(req));
//		String re = "added";
//		// m.addObject(re);
//		m.addObject("res", re);
//
		m.setViewName("result.jsp");
		return m;
	}
	private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
	
	
	@GetMapping("/verify")
	public ModelAndView verifyUser(@Param("code") String code) {
		ModelAndView mv = new ModelAndView();
	    if (main.verify(code)) {
	    	mv.setViewName("verify_success.jsp");
	        return mv;
	    } else {
	    	mv.setViewName("verify_fail.jsp");
	        return mv;
	    }
	}
	
	private void sendVerificationEmail(Student s, String siteURL)
	        throws MessagingException, UnsupportedEncodingException {
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
	    String toAddress = s.getUserID();
	    String fromAddress = "srcplacements06@gmail.com";
	    String senderName = "SRC Placements";
	    String subject = "Please verify your registration";
	    String content = "Dear [[name]],<br>"
	            + "Please click the link below to verify your registration:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	            + "Thank you,<br>"
	            + "SRC Placements.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", s.getName());
	    String verifyURL = siteURL + "/verify?code=" + s.getVerificationCode();
	     
	    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	     
	}
	
	@RequestMapping("studentlogincheck")
	public ModelAndView Studentlogin(Student s) {
		ModelAndView m = new ModelAndView();
		
		Student stu = main.checkStudentLogin(s.getUserID(), s.getPassword());
		if(s.getPassword().equals(main.OTP1))
		{
			m.setViewName("changePassword.jsp");
			this.username = stu.getUserID();
			session.setAttribute("loggedInUser_userName", username);
			return m;
		}
	
		else if(stu.isEnabled()) {
			m.addObject("Student", stu);
			m.setViewName("stdindex.jsp");

			this.username = stu.getUserID();
			id = session.getId();
			session.setAttribute("loggedInUser_userName", username);
			return m;
		
	}
		m.setViewName("verify_fail.jsp");
		return m;
	}

	@RequestMapping("getJobOffers")
	public ModelAndView getJobOffers() {
		ModelAndView m = new ModelAndView();
		m.setViewName("viewJobOffers.jsp");
		m.addObject("list", main.getJobOffList());
		return m;
	}

	@RequestMapping("applyJobController")
	public ModelAndView applyJobControllerController(Student s, JobOffers j) throws UnsupportedEncodingException, MessagingException {
		
		return main.applyToJob(j.getJobid(), s.getUserID());
		
		
	}

	@RequestMapping("/applyjob")
	public ModelAndView applyJobs() {
		ModelAndView m = new ModelAndView();
		GetJobOffers g = main.get();
		List<JobOffers> l = g.getL();
		System.out.println(l.size() + "  ---- " + l.get(0).getPostedbyusername());
		m.addObject("list", l);
		m.setViewName("applyJobs.jsp");
		return m;
	}

	@RequestMapping("viewallstudents")
	public ModelAndView viewallstudents() {
		ModelAndView m = new ModelAndView();
		List<Student> l = repo.findAll();
		m.addObject("list", l);
		m.setViewName("veiwstudent.jsp");
		return m;
	}

	@RequestMapping("/logout1")
    public ModelAndView logout(HttpServletRequest request){
	ModelAndView mav = new ModelAndView();
    HttpSession session = request.getSession(false);
    
      if (session != null) {
          session.invalidate();
      }
      
      mav.setViewName("stdlgn.jsp");
        return mav;
    }

	@RequestMapping("updateStudentData")
	public ModelAndView updateStudentData(Student s) {
		ModelAndView m = new ModelAndView();
		s = main.updateStudentData(s);
		m.addObject("loggedInUser_userName", s.getCollegeID());
		m.setViewName("stdindex.jsp");
		return m;
	}
	
	
	@RequestMapping("/profile")
	public ModelAndView stdProfile(Student s)
	{
		ModelAndView mv = new ModelAndView();
		 Student sp = repo.findById(username).orElse(null);
		 
		 mv.addObject("profile",sp);
		 //mv.addObject("uname", username);
		 mv.setViewName("stdprofile.jsp");
		 return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(Student s)
	{
		ModelAndView mv = new ModelAndView();
		 Student sp = repo.findById(username).orElse(null);
		 session.setAttribute("loggedInUser_userName", username);
		 mv.addObject("profile",sp);
		 
		 mv.setViewName("updProfile.jsp");
		 return mv;
	}
	
	@RequestMapping("/uptdProfile")
	public ModelAndView editProfile(Student s)
	{
		ModelAndView mv = new ModelAndView();		
		 repo.save(s);
		 mv.setViewName("stdindex.jsp");
		 return mv;
	}
	@RequestMapping("/emailCheck")
	  public ModelAndView emailCheck(Student s) {
	    return main.emailCheck(s);
	  }
	
	@RequestMapping("/changePass")
	public ModelAndView changePassword(@RequestParam("userID")String userID,@RequestParam("password") String password)
	{
		return main.changePassword(userID,password);
	}

	
	
//	@RequestMapping("/error")
//	public ModelAndView handleError(HttpServletRequest request) {
//	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//	    ModelAndView mv = new ModelAndView();
//	    if (status != null) 
//	        	mv.setViewName("error.jsp");
//	            return mv;	        
//	}
	
	
	
	@GetMapping("/register123")
	  public ModelAndView showForm(Model model) {
	    ModelAndView m=new ModelAndView();
	    m.setViewName("forml.jsp");
	    m.addObject("student",new Student());
	    
	    
	    return m;
	  }
	  
	  @PostMapping("/register123")
	  public ModelAndView submitForm(@Valid @ModelAttribute("student") Student student,
	      BindingResult bindingResult, ModelAndView model,HttpServletRequest req) throws UnsupportedEncodingException, MessagingException 
	  {
	    System.out.println("Professing form...");
	    System.out.println(student.getUserID());
	    
	    if (bindingResult.hasErrors()) 
	    {
	        
	      model.setViewName("forml.jsp");
	      return model;
	    }
	    String randomCode = RandomString.make(64);
	    student.setVerificationCode(randomCode);
	    student.setEnabled(false);
		repo.save(student);
		sendVerificationEmail(student, getSiteURL(req));
	    model.setViewName("result.jsp");
	    return model;
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}