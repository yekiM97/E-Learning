package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.config.ApiConfig;
import com.myclass.dto.CourseDTO;
import com.myclass.dto.User_CourseDTO;
import com.myclass.service.ICourseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiConfig.COURSE)
public class CourseController {

	@Autowired
	private ICourseService iCourseService;

	@RequestMapping(value = "getListCourse", method = RequestMethod.POST)
	public ResponseEntity<List<CourseDTO>> getListCourse() {
		try {
			List<CourseDTO> listCourse = iCourseService.getListCourse();
			return new ResponseEntity<List<CourseDTO>>(listCourse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<CourseDTO>>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "getListCourseByID", method = RequestMethod.POST)
	public ResponseEntity<List<CourseDTO>> getListCourseByID(@RequestBody User_CourseDTO dto) {
		try {
			List<CourseDTO> listCourse = iCourseService.getListCourseByID(dto.getUser_id());
			return new ResponseEntity<List<CourseDTO>>(listCourse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<CourseDTO>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "addCourse", method = RequestMethod.POST)
	public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO dto) {
		try {

			return new ResponseEntity<CourseDTO>(iCourseService.add(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "editCourse", method = RequestMethod.POST)
	public ResponseEntity<CourseDTO> editCourse(@RequestBody CourseDTO dto) {
		try {

			return new ResponseEntity<CourseDTO>(iCourseService.edit(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "findCourseByID", method = RequestMethod.POST)
	public ResponseEntity<CourseDTO> findCourseByID(@RequestBody CourseDTO dto) {
		try {
			return new ResponseEntity<CourseDTO>(iCourseService.findByID(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "deleteCourse", method = RequestMethod.POST)
	public ResponseEntity<Integer> deleteCourse(@RequestBody CourseDTO dto) {
		try {

			return new ResponseEntity<Integer>(iCourseService.delete(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
	}
}
