package com.sdp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Result {

	@Id
	private int id;
	private int examID;
	
	private double score;
	private String username;
	public int getExamID() {
		return examID;
	}
	public void setExamID(int examID) {
		this.examID = examID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
