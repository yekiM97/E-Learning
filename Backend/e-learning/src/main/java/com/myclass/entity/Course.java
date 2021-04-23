package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "courses")
@JsonInclude(Include.NON_NULL)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "content")
	private String content;

	// new
	@Column(name = "image")
	private String image;

	@Column(name = "leture_count")
	private int leture_count;

	@Column(name = "hour_count")
	private int hour_count;

	@Column(name = "view_count")
	private int view_count;

	@Column(name = "price")
	private double price;

	@Column(name = "discount")
	private int discount;

	@Column(name = "promotion_price")
	private double promotion_price;

	@Column(name = "last_update")
	private String last_update;
	//
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "position")
	private String position;

	@Column(name = "cate_id")
	private int cate_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cate_id", insertable = false, updatable = false)
	private Category category;

	@OneToMany(mappedBy = "target_course", fetch = FetchType.LAZY)
	private List<Target> targets;

	@OneToMany(mappedBy = "user_course", fetch = FetchType.LAZY)
	private List<User_Course> user_course;

	@OneToMany(mappedBy = "video_course", fetch = FetchType.LAZY)
	private List<Video> video;

	public Course() {
		super();
	}

	public Course(int id, String title, String description, String content, int cate_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.cate_id = cate_id;
	}

	public Course(int id, String title, String description, String content, String image, int leture_count,
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

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
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

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

	public List<User_Course> getUser_course() {
		return user_course;
	}

	public void setUser_course(List<User_Course> user_course) {
		this.user_course = user_course;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
