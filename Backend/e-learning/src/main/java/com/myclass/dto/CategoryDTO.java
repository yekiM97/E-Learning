package com.myclass.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CategoryDTO {
	private int id;

	private String name;

	private String icon;

	public CategoryDTO(int id, String name, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
	}

	public CategoryDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
