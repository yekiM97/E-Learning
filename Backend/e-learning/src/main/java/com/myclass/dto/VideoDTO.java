package com.myclass.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class VideoDTO {
	private int id;

	private String title;

	private String url;

	private String time_count;

	private int course_id;

	public VideoDTO() {
		super();
	}

	public VideoDTO(int id, String title, String url, String time_count, int course_id) {
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
}
