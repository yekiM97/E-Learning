package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDTO;


public interface ICategoryService {
	List<CategoryDTO> getListCategory();
	
	List<CategoryDTO> getListCategoryByID(int id);

	CategoryDTO add(CategoryDTO dto);

	CategoryDTO edit(CategoryDTO dto);

	CategoryDTO findByID(int id);

	int delete(int id);
	
	
	
	
}
