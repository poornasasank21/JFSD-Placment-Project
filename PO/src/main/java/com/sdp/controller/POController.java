package com.sdp.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.entity.Exam;
import com.sdp.entity.PO;
import com.sdp.entity.Question;
import com.sdp.entity.Recruiter;
import com.sdp.entity.Student;
import com.sdp.service.EmailSenderService;
import com.sdp.service.POService;

@RestController
public class POController {
  @Autowired
  private POService poserve;
  @Autowired
  private EmailSenderService senderService;
  

  
  public String OTP1 = null;
  @RequestMapping("/")
  public ModelAndView home()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("pomain.jsp");
    return mv;
  }
  
  @RequestMapping("/OTPcheck")
  public ModelAndView OTPCheck(String OTP) {
    
    return poserve.OTPCheck(OTP);
  }
 
 
  
  @RequestMapping("/emailCheck")
  public ModelAndView emailCheck(PO p) {
    return poserve.emailCheck(p);
  }
  
  @RequestMapping("/addRec")
  public ModelAndView addRec(Recruiter r)
  {
    return poserve.addRect(r);
  }
  @RequestMapping("/delRec")
  public ModelAndView delRec(String username)
  {
    return poserve.deleteRect(username);
    
  }
  @RequestMapping("/deleteStudent")
  public ModelAndView deleteStudent(Student s)
  {
    return poserve.deleteStudent(s);
  }
  
  
  @RequestMapping("/addStudent")
  public ModelAndView addStudent(Student s,HttpServletRequest request) throws UnsupportedEncodingException, MessagingException
  {
    return poserve.addStudent(s, getSiteURL(request));
  }
  
  
  private String getSiteURL(HttpServletRequest request) {
      String siteURL = request.getRequestURL().toString();
      return siteURL.replace(request.getServletPath(), "");
  }  
  @RequestMapping("/viewStudents")
	public ModelAndView viewStudents()
	{
		return poserve.viewStudents();
	}
  
  @RequestMapping("/viewProfiles")
  public ModelAndView viewProf()
  {
	  return poserve.viewProf();
  }
  
  
  
  @RequestMapping("/addExam")
  public ModelAndView addExams(Exam e)
  {
	  return poserve.addExams(e);
  }
  
  @RequestMapping("/viewExams")
  public ModelAndView viewExams()
  {
	  return poserve.viewExams();
  }
  
  @RequestMapping("/editExam")
  public ModelAndView editExam(Exam e)
  {	  
	  return poserve.editExam(e);
  }
  
  @RequestMapping("/addqn")
  public ModelAndView addqn(Question q)
  {
	  return poserve.addqn(q);
  }
  
}