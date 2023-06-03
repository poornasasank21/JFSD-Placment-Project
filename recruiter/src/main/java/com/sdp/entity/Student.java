package com.sdp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentpojo")
public class Student 
{
  @Id
  private String userID;
  private String name;
  public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private String password;
  private String gender;
  private String collegeID;
  private String branch;
  private String specilization;
  private String passingOutYear;
  private String cGPA;
  private String linkedinUrl;
  private String githubUrl;
  private String stopstalkUrl;
  private String collegeName;
  public String getBranch() {
    return branch;
  }
  public void setBranch(String branch) {
    this.branch = branch;
  }
  public String getSpecilization() {
    return specilization;
  }
  public void setSpecilization(String specilization) {
    this.specilization = specilization;
  }
  public String getPassingOutYear() {
    return passingOutYear;
  }
  public void setPassingOutYear(String passingOutYear) {
    this.passingOutYear = passingOutYear;
  }
  public String getcGPA() {
    return cGPA;
  }
  public void setcGPA(String cGPA) {
    this.cGPA = cGPA;
  }
  public String getLinkedinUrl() {
    return linkedinUrl;
  }
  public void setLinkedinUrl(String linkedinUrl) {
    this.linkedinUrl = linkedinUrl;
  }
  public String getGithubUrl() {
    return githubUrl;
  }
  public void setGithubUrl(String githubUrl) {
    this.githubUrl = githubUrl;
  }
  public String getStopstalkUrl() {
    return stopstalkUrl;
  }
  public void setStopstalkUrl(String stopstalkUrl) {
    this.stopstalkUrl = stopstalkUrl;
  }
  public String getUserID() {
    return userID;
  }
  public void setUserID(String userID) {
    this.userID = userID;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getCollegeID() {
    return collegeID;
  }
  public void setCollegeID(String collegeID) {
    this.collegeID = collegeID;
  }
  public String getCollegeName() {
    return collegeName;
  }
  public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
  }

}