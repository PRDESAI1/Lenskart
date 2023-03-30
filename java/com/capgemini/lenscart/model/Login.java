package com.capgemini.lenscart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "adminlogin")
public class Login {
	@Id // primary key
	@Column(name = "userid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int userId;

	
	@Column(name = "emailid")
	String emailId;
	
	
	@Column(name = "password")
	String password;
	
	

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(int userId, String emailId, String password) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
