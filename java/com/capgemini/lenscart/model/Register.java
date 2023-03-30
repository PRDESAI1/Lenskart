package com.capgemini.lenscart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "register_Table")
public class Register {
	@Id // primary key
	@Column(name = "userid") // column name in database
	@GeneratedValue(strategy=GenerationType.AUTO)
	int userId;
	@Column(name = "fullname")
	@NotNull
	String fullName;
	
	@NotNull
	@Column(name = "emailid")
	public String emailId;
	
	@NotNull
	@Column(name = "contactno")
	Long contactNo;
	
	@NotNull
	@Column(name = "password")
	public String password;

	// Empty constructor
	public Register() {

	}

	// constructor with field
	public Register(int userId, String fullName, String emailId, Long contactNo, String password) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.password = password;
	}

	// getter and setter
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
