package com.sdp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.dao.JobRepo;
import com.sdp.dao.RecruiterRepo;
import com.sdp.entity.GetAppliedStudents;
import com.sdp.entity.GetJobOffers;
import com.sdp.entity.Job;
import com.sdp.entity.Recruiter;
import com.sdp.entity.Student;
import com.sdp.service.RecruiterService;
@RestController


public class RecruiterController {

	@Autowired
	RecruiterService rs;
	
	@Autowired
	JobRepo jr;
	
	@Autowired
	RecruiterRepo repo;
	
	String username=null,id=null;
	
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    List<Student> l;
	@RequestMapping("/")
	public ModelAndView main()
	{
		System.out.println("in main method in recruiter service");
	ModelAndView mv = new ModelAndView();
		mv.setViewName("main.jsp");
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cmplgn.jsp");
		return mv;
	}
	
	@RequestMapping("reclogin")
	public ModelAndView RecLogin(String username,String pass)
	{
		return rs.RecLogin(username, pass);
	}
	@RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request){
		
        return rs.logut(request);
    }
	
	
	@RequestMapping("/addJob")
	public ModelAndView addJobs(Job j)
	{
		return rs.addJob(j);
	}
	@RequestMapping("/deleteJob")
	public ModelAndView deleteJobs(Job j)
	{
		return rs.deleteJob(j);
	}
	
	@RequestMapping("/viewjobs")
	public ModelAndView viewJobs()
	{
		return rs.viewJobs();
	}
	
	@GetMapping("/getAllJobs")
	  public GetJobOffers getAllJobs()
	  {
	    List<Job> l=rs.getAllJobs();
	    System.out.println(l.size());
	    GetJobOffers getJobOffers=new GetJobOffers();
	    getJobOffers.setL(l);
	    return getJobOffers;
	  }
	@RequestMapping("getAppliedStudents")
	public void showAppliedStudents(Job j,HttpServletResponse response)throws IOException
	{
		
		System.out.println(j.getRole());
		ModelAndView m=new ModelAndView();
		GetAppliedStudents g=rs.showAppliedStudents(j.getJobid());
		 l = g.getL();
		
		workbook = new XSSFWorkbook();
		response.setContentType("application/octet-stream");
        
		String jobrole=jr.findByJobRole(j.getJobid());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+j.getJobid()+"_"+jobrole+"_Students.xlsx";
        response.setHeader(headerKey, headerValue);
         
        //List<User> listUsers = service.listAll();
         
        export(response);
		
		
	}
	
	 private void writeHeaderLine() {
		 sheet = workbook.createSheet("Applied Students");
	        Row row = sheet.createRow(0);
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	        
	        //Header Content//headings..
	        createCell(row,0,"Mail ID",style);
	        createCell(row,1,"College Name",style);
	        createCell(row,2,"College ID",style);
	        createCell(row,3,"Name",style);
	        createCell(row,4,"GPA",style);
	        createCell(row, 5, "Gender", style);
	        
	         
	    }
	
	 
	 private void writeDataLines() {
	        int rowCount = 1;
	 
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	            
	        for (int i=0;i<l.size();i++) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	             
	            createCell(row, columnCount++, l.get(i).getUserID(), style);
	            createCell(row, columnCount++, l.get(i).getCollegeName(), style);
	            createCell(row, columnCount++, l.get(i).getCollegeID(), style);
	            createCell(row, columnCount++, l.get(i).getName(), style);
	            createCell(row, columnCount++, l.get(i).getcGPA(), style);
	            createCell(row, columnCount++, l.get(i).getGender(), style);
	             
	        }
	    }
	 
	 
	 public void export(HttpServletResponse response) throws IOException {
	        writeHeaderLine();
	        writeDataLines();
	         
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	         
	    }
	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
	@RequestMapping("/changePass")
	public ModelAndView changePassword(String pass)
	{
		return rs.changePassword(pass);		
	}
	
}
