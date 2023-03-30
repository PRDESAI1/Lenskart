package com.capgemini.lenscart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "debit")
public class DebitPayement {
	@Id // primary key
	@Column(name = "id") // column name in database
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "name")
   private String name;
	
	@Column(name = "cardNum")
	private String cardNum;

	@Column(name = "password")
    private String password;

	public DebitPayement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DebitPayement(int id, String name, String cardNum, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cardNum = cardNum;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
