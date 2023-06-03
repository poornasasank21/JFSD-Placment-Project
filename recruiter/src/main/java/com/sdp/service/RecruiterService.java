package com.sdp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.dao.JobRepo;
import com.sdp.dao.RecruiterRepo;
import com.sdp.entity.GetAppliedStudents;
import com.sdp.entity.Job;
import com.sdp.entity.Recruiter;
//import com.sdp.entity.Student;
import com.sdp.entity.Student;

@Service

public class RecruiterService {

	@Autowired
	JobRepo jrepo;
	@Autowired
	RecruiterRepo repo;
	@Autowired
	HttpSession session;
	String username=null,id=null;
	@Autowired
	RestTemplate rt;
	
	public ModelAndView RecLogin(String username,String pass)
	{
		ModelAndView mv = new ModelAndView();

		List<Recruiter> rc = repo.findAll();
		for(int i=0;i<repo.count();i++)
		{
			Recruiter r = rc.get(i);
			if((r.getUsername().equals(username))&&r.getPassword().equals(pass))
			{
				if(r.getPassword().equals("Welcome@123"))
				{
					this.username=username;
					id=session.getId();
					session.setAttribute("loggedInUser_userName", username);
						mv.setViewName("changePassword.jsp");
						return mv;
				}
				this.username=username;
				id=session.getId();
				session.setAttribute("loggedInUser_userName", username);
				mv.setViewName("recindex.jsp");
				return mv;
				
			}
		}

		mv.setViewName("cmplgn.jsp");
		return mv;
	}
	
	
	public ModelAndView logut(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false);
		
	    if (session != null) {
	        session.invalidate();
	    }
	    mv.setViewName("cmplgn.jsp");
	    return mv;
	}
		
	public ModelAndView addJob(Job j)
	{
		ModelAndView mv= new ModelAndView();
		List<Job> jl = jrepo.findAll();
		for(int i=0;i<jrepo.count();i++)
		{
			Job jp = jl.get(i);
			if(jp.getJobid()==j.getJobid())
			{
				 mv.addObject("res","Job ID already exists!!");
				  mv.setViewName("exception.jsp");
				  return mv;
			}
		}
		Recruiter r=new Recruiter();		
		j.setPostedbyusername(username);
		jrepo.save(j);
		mv.setViewName("result.jsp");
		
		return mv;
	}
	
	public ModelAndView deleteJob(Job j) {
		  ModelAndView mv = new ModelAndView();
		    
		  List<Job> jl = jrepo.findAll();
		  
		  for(int i=0;i<jrepo.count();i++)
		  {
			  Job jp = jl.get(i);
			  if(jp.getJobid()==j.getJobid())
			  {
				  jrepo.deleteById(j.getJobid());
				  mv.setViewName("recindex.jsp");
				   return mv;			
			  }
			   
		  }
		  mv.addObject("res","Job Doesnot exists!!");
		  mv.setViewName("exception.jsp");
		  return mv;
	    
	  }
	
	
	
	public ModelAndView viewJobs()
	{
		ModelAndView mv = new ModelAndView();
		List<Job> jb = jrepo.findAll();
		mv.addObject("joboffers",jb);
		mv.addObject("uname", username);
		mv.setViewName("viewjobs.jsp");
		return mv;
	}
	

	public List<Job> getAllJobs()
	  {
	    List<Job> jb = jrepo.findAll();
	    System.out.println(jb.size());
	    return jb;
	  }

	public GetAppliedStudents showAppliedStudents(long jobid) 
	{
		
		GetAppliedStudents g=rt.getForObject("http://localhost:9092/getAppliedStudents/"+jobid,GetAppliedStudents.class);
		
		return g;
		
	}
	public ModelAndView changePassword(String pass)
	{
		ModelAndView mv=new ModelAndView();
		if(pass.equals("Welcome@123"))
		{
			mv.addObject("res","Password Must Change");
			mv.setViewName("exception.jsp");
			return mv;
		}
		Recruiter r = repo.findById(username).orElse(null);
		r.setPassword(pass);
		repo.save(r);
		mv.setViewName("recindex.jsp");
		return mv;
	}
	
}
