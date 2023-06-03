package com.sdp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="studentpojo")
public class Student 
{
  @Id
  @Email
  @NotBlank(message = "compulsary")
  private String userID;
  @Size(min = 5,max = 10)
  private String password;
  @NotBlank
  private String gender;
  @NotBlank
  @Size(max = 15,min = 4)
  private String collegeID;
  private String branch;
  private String specilization;
  private String passingOutYear;
  private String cGPA;
  private String linkedinUrl;
  private String githubUrl;
  private String stopstalkUrl;
  @NotBlank
  @Size(min = 4,max = 40)
  private String collegeName;
  @Size(max = 15,min = 4)
  private String name;
  private String codeforces;
  private String codechef;
  private String spoj;
  private String interviewBit;
  private String leetcode;
  @Column(name="verification_code",length=64)
  private String verificationCode;  
  private boolean enabled;
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
public String getCollegeName() {
  return collegeName;
}
public void setCollegeName(String collegeName) {
  this.collegeName = collegeName;
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}
public String getCodeforces() {
  return codeforces;
}
public void setCodeforces(String codeforces) {
  this.codeforces = codeforces;
}
public String getCodechef() {
  return codechef;
}
public void setCodechef(String codechef) {
  this.codechef = codechef;
}
public String getSpoj() {
  return spoj;
}
public void setSpoj(String spoj) {
  this.spoj = spoj;
}
public String getInterviewBit() {
  return interviewBit;
}
public void setInterviewBit(String interviewBit) {
  this.interviewBit = interviewBit;
}
public String getLeetcode() {
  return leetcode;
}
public void setLeetcode(String leetcode) {
  this.leetcode = leetcode;
}
public String getVerificationCode() {
  return verificationCode;
}
public void setVerificationCode(String verificationCode) {
  this.verificationCode = verificationCode;
}
public boolean isEnabled() {
  return enabled;
}
public void setEnabled(boolean enabled) {
  this.enabled = enabled;
}
}