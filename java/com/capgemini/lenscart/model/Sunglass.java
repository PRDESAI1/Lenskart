package com.capgemini.lenscart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sunglass")
public class Sunglass {

	@Id // primary key
	@Column(name = "sunglassid") // column name in database
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;

	@Column(name = "name")
	private String Name;

	@Column(name = "brand")
	private String Brand;

	@Column(name = "price")
	private int Price;

	@Column(name = "image")
	private String image;

	@Column(name = "frameshape")
	private String FrameShape;

	@Column(name = "glasscolor")
	private String GlassColur;

	@Column(name = "weight")
	private int Weight;

	@Column(name = "framecolor")
	private String FrameColor;

	// constructor with field
	

	// Empty constructor
	public Sunglass() {

	}
	
	
	
	
	
	public Sunglass(int id, String name, String brand, int price, String image, String frameShape, String glassColur,
			int weight, String frameColor) {
		super();
		Id = id;
		Name = name;
		Brand = brand;
		Price = price;
		image = image;
		FrameShape = frameShape;
		GlassColur = glassColur;
		Weight = weight;
		FrameColor = frameColor;
		
	}

	// getter and setter
	
	

	public int getId() {
		return Id;
	}

	

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFrameShape() {
		return FrameShape;
	}

	public void setFrameShape(String frameShape) {
		FrameShape = frameShape;
	}

	public String getGlassColur() {
		return GlassColur;
	}

	public void setGlassColur(String glassColur) {
		GlassColur = glassColur;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public String getFrameColor() {
		return FrameColor;
	}

	public void setFrameColor(String frameColor) {
		FrameColor = frameColor;
	}

}
