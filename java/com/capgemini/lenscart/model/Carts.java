package com.capgemini.lenscart.model;



import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart2")
public class Carts {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	
	private int productId;
	
//	private int totalamount;
//	private String paymenttype;

	
	// Empty constructor
	public Carts() {
		
	}

	public Carts(int customerId, int productId) {
		super();
		this.customerId = customerId;
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
}
	
	
	