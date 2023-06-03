package com.sdp.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Job {

	
	@Id	
	@Column(name="jobid")
	private long  jobid;
	@Column(name="postuser")
	private String postedbyusername;
	@Column(name="location")
	private String location;
	@Column(name="role")
	private String role;
	@Column(name="descp" ,columnDefinition = "longtext")
	private String description;
	
	@Column(name="qualf",columnDefinition = "LONGTEXT")
	private String qualification;
	
	@Column(name="resp",columnDefinition = "LONGTEXT")
	private String responsibilities;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name="lastDate")
	private Date lastDate;
	
	public long getJobid() {
		return jobid;
	}
	public void setJobid(long jobid) {
		this.jobid = jobid;
	}
	public String getPostedbyusername() {
		return postedbyusername;
	}
	public void setPostedbyusername(String postedbyusername) {
		this.postedbyusername = postedbyusername;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	
	
	
}
