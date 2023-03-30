package com.capgemini.lenscart.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "frame2")
public class Frame {

	@Id // primary key
	@Column(name = "frameid") // column name in database
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int frameId;

	@Column(name = "name")
	private String frameName;

	
	@Column(name = "image")
	private String frameImage;
	
	@Column(name = "color")
	private String color;

	@Column(name = "price")
	private int price;

	@Column(name = "description")
	private String desc;

	@Column(name = "shape")
	private String shape;

	@Column(name = "size")
	private String size;
	
	

	
	

	// Empty constructor
	public Frame() {

	}






	public int getFrameId() {
		return frameId;
	}






	public void setFrameId(int frameId) {
		this.frameId = frameId;
	}






	public String getFrameName() {
		return frameName;
	}






	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}






	public String getFrameImage() {
		return frameImage;
	}






	public void setFrameImage(String frameImage) {
		this.frameImage = frameImage;
	}






	public String getColor() {
		return color;
	}






	public void setColor(String color) {
		this.color = color;
	}






	public int getPrice() {
		return price;
	}






	public void setPrice(int price) {
		this.price = price;
	}






	public String getDesc() {
		return desc;
	}






	public void setDesc(String desc) {
		this.desc = desc;
	}






	public String getShape() {
		return shape;
	}






	public void setShape(String shape) {
		this.shape = shape;
	}






	public String getSize() {
		return size;
	}






	public void setSize(String size) {
		this.size = size;
	}

	public Frame(int frameId, String frameName, String frameImage, String color, int price, String desc, String shape,
			String size) {
		super();
		this.frameId = frameId;
		this.frameName = frameName;
		this.frameImage = frameImage;
		this.color = color;
		this.price = price;
		this.desc = desc;
		this.shape = shape;
		this.size = size;
	}






}