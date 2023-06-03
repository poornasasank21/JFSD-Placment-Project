package com.sdp.services;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.dao.JobApplicationsRepo;

import com.sdp.dao.StudentRepo;
import com.sdp.entity.GetAppliedStudents;
import com.sdp.entity.GetJobOffers;
import com.sdp.entity.JobApplications;
import com.sdp.entity.JobOffers;

import com.sdp.entity.Student;

@Service

public class Main {
	@Autowired
	public StudentRepo repo;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	public JobApplicationsRepo arepo;
	
	 @Autowired
	    private JavaMailSender mailSender;
	 
	 @Autowired
	  private EmailSenderService senderService;
	 
	 GetJobOffers gj;
	 
	 public String OTP1=null;
	 
	public GetAppliedStudents getAllstudents()
	{
		GetAppliedStudents gas=new GetAppliedStudents();
		List<Student> l=repo.findAll();
		gas.setL(l);
		return gas;
	}
	public Student checkStudentLogin(String id,String pass)
	{
		Student s=repo.checkLogin(id, pass);
		
		return s;
	}
	public ModelAndView applyToJob(long jobid,String userID) throws UnsupportedEncodingException, MessagingException
	{
		ModelAndView mv = new ModelAndView();
		List<JobApplications> jl=arepo.findAll();
		for(int i=0;i<arepo.count();i++)
		{
			JobApplications jp = jl.get(i);
			if(jp.getJobid()==jobid && jp.getUserID().equals(userID))
			{
				mv.addObject("res","Already applied!!");
				  mv.setViewName("exception.jsp");
				  return mv;
			}
		}
				
		JobApplications j=new JobApplications();
		j.setJobid(jobid);
		j.setUserID(userID);
		Student s = repo.findById(userID).orElse(null);
		String role=null;
		 List<JobOffers> l = gj.getL();
		    for(int i=0;i<l.size();i++)
		    {
		    	if(l.get(i).getJobid()==j.getJobid())
		    	{
		    		 role=l.get(i).getRole();
		    	}
		    }
		
		
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
	    String toAddress = userID;
	    String fromAddress = "srcplacements06@gmail.com";
	    String senderName = "SRC Placements";
	    String subject = "Job Applied Successfully :)";
	    String content = "Dear [[name]],<br>"
	            + "Please Check the details below to verify your Applied Job:<br>"
	            + "[[role]]<br>"
	            + "Your Profile is updated to Recruiter..<br>"
	            + "They look forward to reviewing your application<br>"
	            + "You will receive an email from them at any time if you are get shortlisted.<br>"
	            + "We appreciate your interest in a career with us,<br>"
	            + "Thank you,<br>"
	            + "SRC Placements.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
		
	    content = content.replace("[[name]]", s.getName());
	   
	    content = content.replace("[[role]]", role);
	     
	    
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);

		arepo.save(j);
		mv.setViewName("jobResult.jsp");
		return mv;
	}
	public GetJobOffers getJobOffList() {
		GetJobOffers g=restTemplate.getForObject("http://localhost:9091/getAllJobs", GetJobOffers.class);
		
		return g;
	}
	public GetJobOffers get()
	{
		System.out.println("beforrestcall");
		GetJobOffers j=restTemplate.getForObject("http://localhost:9091/getAllJobs", GetJobOffers.class);
		gj=restTemplate.getForObject("http://localhost:9091/getAllJobs", GetJobOffers.class);
		//System.out.println(l.size()+"  ---- "+l.get(0).getPostedbyusername());
		
		return j;
	}
	public List<JobApplications> getAppliedStudentsForJob(long jobid) {
		List<JobApplications> j=arepo.getAppliedStudents(jobid);
		return j;
	}
	public Student updateStudentData(Student s) 
	  {
	    return repo.save(s);
	  }
	
	public boolean verify(String verificationCode) {
	    Student s = repo.findByVerificationCode(verificationCode);
	     
	    if (s == null || s.isEnabled()) {
	        return false;
	    } else {
	        s.setVerificationCode(null);
	        s.setEnabled(true);
	        repo.save(s);
	         
	        return true;
	    }
	}
	public ModelAndView emailCheck(Student s) {
		ModelAndView mv = new ModelAndView();
		List<Student> sl = repo.findAll();
		  
		  for(int i=0;i<repo.count();i++)
		  {
			  Student sp = sl.get(i);
			  if(sp.getUserID().equals(s.getUserID()))
			  {
				  Random random = new Random();
			        StringBuilder sb = new StringBuilder();    
			        sb.append(random.nextInt(50000 - 10000) + 10000);//high: 50K | low: 10K
			         OTP1=sb.toString();
			         Student st = repo.findById(s.getUserID()).orElse(null);
			         st.setPassword(OTP1);
			        senderService.sendEmail(s.getUserID(),//to email 
			            "Change the password using Login with this OTP ", 
			            OTP1);
			        
			    	mv.setViewName("stdlgn.jsp");
			    	return mv;	
			  }
			   
		  }
		  mv.addObject("res","User Doesnot exists!!");
		  mv.setViewName("exception.jsp");
		  return mv;
	    
	} 
	public ModelAndView changePassword(String username,String pass)
	{
		ModelAndView mv=new ModelAndView();
		if(pass.equals(OTP1))
		{
			mv.addObject("res","Password Must Change");
			mv.setViewName("exception.jsp");
			return mv;
		}
		Student s = repo.findById(username).orElse(null);
		s.setPassword(pass);
		repo.save(s);
		mv.setViewName("stdindex.jsp");
		return mv;
	}
	
	 
	
	

}
