package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "videos")
@JsonInclude(Include.NON_NULL)
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "url")
	private String url;

	@Column(name = "time_count")
	private String time_count;

	@Column(name = "course_id")
	private int course_id;
	
	@ManyToOne
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Course video_course;

	public Video() {
		super();
	}

	public Video(int id, String title, String url, String time_count, int course_id) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.time_count = time_count;
		this.course_id = course_id;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTime_count() {
		return time_count;
	}

	public void setTime_count(String time_count) {
		this.time_count = time_count;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public Course getVideo_course() {
		return video_course;
	}

	public void setVideo_course(Course video_course) {
		this.video_course = video_course;
	}
	
	
	
}
