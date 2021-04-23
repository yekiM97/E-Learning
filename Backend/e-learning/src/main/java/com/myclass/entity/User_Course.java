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
@Table(name = "user_courses")
@JsonInclude(Include.NON_NULL)
public class User_Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "role_id")
	private int role_id;

	@Column(name = "user_id")
	private int user_id;

	@Column(name = "course_id")
	private int course_id;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User users;

	@ManyToOne
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Course user_course;

	public User_Course(int id, int role_id, int user_id, int course_id) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.user_id = user_id;
		this.course_id = course_id;
	}

	public User_Course() {
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

	public Course getUser_course() {
		return user_course;
	}

	public void setUser_course(Course user_course) {
		this.user_course = user_course;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
