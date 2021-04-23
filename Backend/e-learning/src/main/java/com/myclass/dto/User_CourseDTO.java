package com.myclass.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class User_CourseDTO {
	private int id;

	private int role_id;

	private int user_id;

	private int course_id;

	public User_CourseDTO(int id, int role_id, int user_id, int course_id) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.user_id = user_id;
		this.course_id = course_id;
	}

	public User_CourseDTO() {
		super();
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
