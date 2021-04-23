package com.myclass.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CourseDTO {
	private int id;

	private String title;

	private String description;

	private String content;
	
	private String image;

	private int leture_count;

	private int hour_count;

	private int view_count;

	private double price;

	private int discount;

	private double promotion_price;

	private String last_update;
	
	private String author;
	
	private String position;

	private int cate_id;

	public CourseDTO() {
		super();
	}

	public CourseDTO(int id, String title, String description, String content, int cate_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.cate_id = cate_id;
	}
	
	public CourseDTO(int id, String title, String description, String content, String image, int leture_count,
			int hour_count, int view_count, double price, int discount, double promotion_price, String last_update,String author, String position,
			int cate_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.image = image;
		this.leture_count = leture_count;
		this.hour_count = hour_count;
		this.view_count = view_count;
		this.price = price;
		this.discount = discount;
		this.promotion_price = promotion_price;
		this.last_update = last_update;
		this.author = author;
		this.position = position;
		this.cate_id = cate_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLeture_count() {
		return leture_count;
	}

	public void setLeture_count(int leture_count) {
		this.leture_count = leture_count;
	}

	public int getHour_count() {
		return hour_count;
	}

	public void setHour_count(int hour_count) {
		this.hour_count = hour_count;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getPromotion_price() {
		return promotion_price;
	}

	public void setPromotion_price(double promotion_price) {
		this.promotion_price = promotion_price;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
}
