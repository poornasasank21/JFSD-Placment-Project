package com.sdp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_po")
public class PO {
	@Id
	@Column(name="po_email")
	private String poEmail;
	@Column(name="po_id")
	private String poID;
	@Column(name="po_password")
	private String poPassword;
	
	public String getPoEmail() {
		return poEmail;
	}
	public void setPoEmail(String poEmail) {
		this.poEmail = poEmail;
	}
	public String getPoID() {
		return poID;
	}
	public void setPoID(String poID) {
		this.poID = poID;
	}
	public String getPoPassword() {
		return poPassword;
	}
	public void setPoPassword(String poPassword) {
		this.poPassword = poPassword;
	}
}
