package com.capgemini.lenscart.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "glass")

public class Glass {

	@Id // primary key
	@Column(name = "glassid") // column name in database
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int glassId;

	@Column(name = "name")
	private String glassName;

	@Column(name = "brand")
	private String glassBrand;

	@Column(name = "price")
	private int glassPrice;

	@Column(name = "image")
	private String glassimage;

	@Column(name = "type")
	private String glassType;

	@Column(name = "powerrange")
	private int glassPowerRange;


	public Glass() {

	}
	
	
	
	
	public Glass(int glassId, String glassName, String glassBrand, int glassPrice, String glassimage, String glassType,
			int glassPowerRange) {
		super();
		this.glassId = glassId;
		this.glassName = glassName;
		this.glassBrand = glassBrand;
		this.glassPrice = glassPrice;
		this.glassimage = glassimage;
		this.glassType = glassType;
		this.glassPowerRange = glassPowerRange;
		
	}

	

	public int getGlassId() {
		return glassId;
	}

	public void setGlassId(int glassId) {
		this.glassId = glassId;
	}

	public String getGlassName() {
		return glassName;
	}

	public void setGlassName(String glassName) {
		this.glassName = glassName;
	}

	public String getGlassBrand() {
		return glassBrand;
	}

	public void setGlassBrand(String glassBrand) {
		this.glassBrand = glassBrand;
	}

	public int getGlassPrice() {
		return glassPrice;
	}

	public void setGlassPrice(int glassPrice) {
		this.glassPrice = glassPrice;
	}

	public String getGlassimage() {
		return glassimage;
	}

	public void setGlassimage(String glassimage) {
		this.glassimage = glassimage;
	}

	public String getGlassType() {
		return glassType;
	}

	public void setGlassType(String glassType) {
		this.glassType = glassType;
	}

	public int getGlassPowerRange() {
		return glassPowerRange;
	}

	public void setGlassPowerRange(int glassPowerRange) {
		this.glassPowerRange = glassPowerRange;
	}

}
