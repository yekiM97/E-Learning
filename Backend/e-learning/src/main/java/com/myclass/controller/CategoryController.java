package com.myclass.controller;

import java.util.List;

import com.myclass.config.ApiConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.CategoryDTO;
import com.myclass.service.ICategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiConfig.CATEGORY)
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;

	@RequestMapping(value = "getListCategory", method = RequestMethod.POST)
	public ResponseEntity<List<CategoryDTO>> getListCategory() {
		try {
			List<CategoryDTO> listCate = iCategoryService.getListCategory();
			return new ResponseEntity<List<CategoryDTO>>(listCate, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<CategoryDTO>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "addCategory", method = RequestMethod.POST)
	public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO dto) {
		try {

			return new ResponseEntity<CategoryDTO>(iCategoryService.add(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<CategoryDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "editCategory", method = RequestMethod.POST)
	public ResponseEntity<CategoryDTO> editCategory(@RequestBody CategoryDTO dto) {
		try {

			return new ResponseEntity<CategoryDTO>(iCategoryService.edit(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<CategoryDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "findCategoryByID", method = RequestMethod.POST)
	public ResponseEntity<CategoryDTO> findCategoryByID(@RequestBody CategoryDTO dto) {
		try {

			return new ResponseEntity<CategoryDTO>(iCategoryService.findByID(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<CategoryDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "deleteCategory", method = RequestMethod.POST)
	public ResponseEntity<Integer> deleteCategory(@RequestBody CategoryDTO dto) {
		try {

			return new ResponseEntity<Integer>(iCategoryService.delete(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
	}

}
