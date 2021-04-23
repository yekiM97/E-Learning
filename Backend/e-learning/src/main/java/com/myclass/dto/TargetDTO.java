package com.myclass.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TargetDTO {
	private int id;

	private String title;

	private int course_id;

	public TargetDTO() {
		super();
	}

	public TargetDTO(int id, String title, int course_id) {
		super();
		this.id = id;
		this.title = title;
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

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}
