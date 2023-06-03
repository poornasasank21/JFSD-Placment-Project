package com.sdp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdp.dao.ExamsRepo;
import com.sdp.dao.PORepository;
import com.sdp.dao.QuestionRepo;
import com.sdp.dao.RecruiterIntRepo;
import com.sdp.dao.StudentRepo;
import com.sdp.entity.Exam;
import com.sdp.entity.PO;
import com.sdp.entity.Question;
import com.sdp.entity.Recruiter;
import com.sdp.entity.Student;

import net.bytebuddy.utility.RandomString;

@Service
public class POService {
  @Autowired
  private PORepository porep;

  @Autowired
  RecruiterIntRepo repo;
  @Autowired
  StudentRepo studentRepo;
  
  @Autowired
  ExamsRepo erepo;
  
  @Autowired
  QuestionRepo qrepo;
  
  @Autowired
  private JavaMailSender mailSender;
  
  public int eid;
  public String ename=null;
  
  public String OTP1=null;
  @Autowired
  private EmailSenderService senderService;
  public ModelAndView OTPCheck(String OTP) {
    
    ModelAndView mav = new ModelAndView();
    
    if(OTP1.equals(OTP)) {
      mav.setViewName("polgnsuccess.jsp");
      
      return mav;
    }
    
    mav.setViewName("polgn.jsp");
    return mav;
  }
  

  public ModelAndView emailCheck(PO p) {
    ModelAndView mv = new ModelAndView();
    if(p.getPoEmail().equals("kaychrisharry@gmail.com"))
    {
    	Random random = new Random();
        StringBuilder sb = new StringBuilder();    
        sb.append(random.nextInt(50000 - 10000) + 10000);//high: 50K | low: 10K
         OTP1=sb.toString();
        senderService.sendEmail("kaychrisharry@gmail.com",//to email 
            "OTP for PO login", 
            OTP1);
    	mv.setViewName("polgn.jsp");
    	return mv;
    }
      mv.setViewName("pohome.jsp");
    return mv;    
  }
  

  
  public ModelAndView addRect(Recruiter r)
  {
	  ModelAndView mv = new ModelAndView();
	  List<Recruiter> rl = repo.findAll();
	  
	  for(int i=0;i<repo.count();i++)
	  {
		  Recruiter rp = rl.get(i);
		  if(r.getUsername().equals(rp.getUsername()))
		  {
			  mv.addObject("res","User already exists!!");
			  mv.setViewName("exception.jsp");
			  return mv;
		  }
		   
	  }
    
    mv.setViewName("polgnsuccess.jsp");
    repo.save(r);
    return mv;
  }
  
  public ModelAndView deleteRect(String username)
  {
 
    ModelAndView mv = new ModelAndView();
    
	  List<Recruiter> rl = repo.findAll();
	  
	  for(int i=0;i<repo.count();i++)
	  {
		  Recruiter rp = rl.get(i);
		  if(username.equals(rp.getUsername()))
		  {
			  repo.deleteByUsername(username);
			  mv.setViewName("polgnsuccess.jsp");
			   return mv;			
		  }
		   
	  }
	  mv.addObject("res","User Doesnot exists!!");
	  mv.setViewName("exception.jsp");
	  return mv;
    
    
  }

  public ModelAndView deleteStudent(Student s) {
	  ModelAndView mv = new ModelAndView();
	    
	  List<Student> sl = studentRepo.findAll();
	  
	  for(int i=0;i<studentRepo.count();i++)
	  {
		  Student sp = sl.get(i);
		  if(sp.getUserID().equals(s.getUserID()))
		  {
			  studentRepo.deleteById(s.getUserID());
			  mv.setViewName("polgnsuccess.jsp");
			   return mv;			
		  }
		   
	  }
	  mv.addObject("res","User Doesnot exists!!");
	  mv.setViewName("exception.jsp");
	  return mv;
    
  }

  public ModelAndView addStudent(Student s,String siteURL)throws UnsupportedEncodingException, MessagingException {
	  ModelAndView mv = new ModelAndView();
	  List<Student> sl = studentRepo.findAll();
	  
	  for(int i=0;i<studentRepo.count();i++)
	  {
		  Student sp = sl.get(i);
		  if(s.getUserID().equals(sp.getUserID()))
		  {
			  mv.addObject("res","User already exists!!");
			  mv.setViewName("exception.jsp");
			  return mv;
		  }
		   
	  }
    
	  
	  String randomCode = RandomString.make(64);
	    s.setVerificationCode(randomCode);
	    s.setEnabled(false);
	    studentRepo.save(s);
	    sendVerificationEmail(s, siteURL);
    mv.setViewName("result.jsp");
    
    return mv;
  }
  
  private void sendVerificationEmail(Student s, String siteURL)
	        throws MessagingException, UnsupportedEncodingException {
	    String toAddress = s.getUserID();
	    String verifyURL = "http://localhost:9092/verify?code=" + s.getVerificationCode();
	    String fromAddress = "srcplacements06@gmail.com";
	    String senderName = "SRC Placements";
	    String subject = "Please verify your registration";
	    String content = "Dear [[name]],<br>"
	            + "Please click the link below to verify your registration:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	            + "Thank you,<br>"
	            + "Team SRC Placements.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", s.getName());
	    
	     
	    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	     
	}
  public ModelAndView viewStudents()
	{
	  
		ModelAndView mv=new ModelAndView();
	    List<Student> l=studentRepo.findAll();
	    
	    if(l.isEmpty())
	    {
	    	mv.addObject("res","No Students are exist!!");
			  mv.setViewName("exception.jsp");
			  return mv;
	    }
	    mv.addObject("student", l);
	    mv.setViewName("viewStudents.jsp");
	    return mv;
	}
  
  
//Modify Upto here only.. dont change the below code at any cost/////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  public ModelAndView viewProf()
  {
	  ArrayList<String> plt = new ArrayList<String>();
	  plt.add("codechef");
	  plt.add("codeforces");
	  plt.add("leetcode");
	  plt.add("spoj");
	  plt.add("interviewbit");
	  
	  
	  ModelAndView mv = new ModelAndView();
	  List<Student> st = studentRepo.findAll();
	  ArrayList<JsonNode[]> codechef = new ArrayList<JsonNode[]>();
	  ArrayList<JsonNode[]> codeforces = new ArrayList<JsonNode[]>();
	  ArrayList<JsonNode[]> leetcode = new ArrayList<JsonNode[]>();
	  ArrayList<JsonNode[]> spoj = new ArrayList<JsonNode[]>();
	  ArrayList<JsonNode[]> interviewbit = new ArrayList<JsonNode[]>();
	  for(int j=0;j<plt.size();j++)
	  {		  
		  if(plt.get(j).equals("codeforces"))
		  {
			  JsonNode[] rating = new JsonNode[(int) studentRepo.count()];
			  JsonNode[] rank = new JsonNode[(int) studentRepo.count()];
			  
			  
			  for(int i=0;i<studentRepo.count();i++)
			  {
				  
					  Student sl = st.get(i);
					  String url = "https://codeforces.com/api/user.info?handles="+sl.getCodeforces();
					  try 
					  {			
						  JsonNode node = POService.get(url);
						  
						  
						 
					        rating[i]=node;
					        rank[i]=node.get("rank");			               			        
					  }
					  catch(Exception e)
					  {
						  System.out.println("Excception");
					  }	
			  }
			  codeforces.add(rating);
			  codeforces.add(rank);
			  
			  
		  }
		  
		 
	}
	  	  	

	  mv.addObject("codeforces", codeforces);
	  mv.addObject("codechef", codechef);	
	  mv.addObject("leetcode", leetcode);
	  mv.addObject("spoj", spoj);
	  mv.addObject("interviewbit", interviewbit);
	  mv.addObject("student", st);
	  mv.setViewName("viewProfiles.jsp");
	  return mv;
	  
  }
  public static JsonNode get(String url) throws StreamReadException, DatabindException, MalformedURLException, IOException {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode json = mapper.readTree(new URL(url));
      return json;
  }
  
  
  public ModelAndView addExams(Exam e)
  {
	  ModelAndView mv = new ModelAndView();
	  erepo.save(e);
	  mv.setViewName("viewExams.jsp");
	  return mv;
  }
  
  public ModelAndView viewExams()
  {
	  ModelAndView mv = new ModelAndView();
		List<Exam> er = erepo.findAll();
		mv.addObject("exams",er);
		
		mv.setViewName("viewExams.jsp");
		return mv;
  }
  
  public ModelAndView editExam(Exam e)
  {
	  ModelAndView mv = new ModelAndView();
	  eid = e.getExamID();
	  ename = e.getExamName();
	  mv.setViewName("editExam.jsp");
	  return mv;
  }
  
  public ModelAndView addqn(Question q)
  {
	  ModelAndView mv = new ModelAndView();
	  q.setExamID(eid);
	  q.setChose(-1);
	  qrepo.save(q);
	  mv.setViewName("editExam.jsp");
	  return mv;
	  
  }
  
  
  
  
}