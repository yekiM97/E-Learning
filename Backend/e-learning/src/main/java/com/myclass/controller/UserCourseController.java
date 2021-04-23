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
import com.myclass.dto.User_CourseDTO;
import com.myclass.service.IUserCourseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiConfig.USER_COURSE)
public class UserCourseController {
	@Autowired
	private IUserCourseService iUserCourseService;

	@RequestMapping(value = "getListUserCourse", method = RequestMethod.POST)
	public ResponseEntity<List<User_CourseDTO>> getListUserCourse() {
		try {
			List<User_CourseDTO> listUserCourse = iUserCourseService.getListUserCourse();
			return new ResponseEntity<List<User_CourseDTO>>(listUserCourse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<User_CourseDTO>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "addUserCourse", method = RequestMethod.POST)
	public ResponseEntity<User_CourseDTO> addUserCourse(@RequestBody User_CourseDTO dto) {
		try {

			return new ResponseEntity<User_CourseDTO>(iUserCourseService.add(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<User_CourseDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "editUserCourse", method = RequestMethod.POST)
	public ResponseEntity<User_CourseDTO> editUserCourse(@RequestBody User_CourseDTO dto) {
		try {

			return new ResponseEntity<User_CourseDTO>(iUserCourseService.edit(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<User_CourseDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "findUserCourseByID", method = RequestMethod.POST)
	public ResponseEntity<User_CourseDTO> findUserCourseByID(@RequestBody User_CourseDTO dto) {
		try {

			return new ResponseEntity<User_CourseDTO>(iUserCourseService.findByID(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<User_CourseDTO>(HttpStatus.BAD_REQUEST);
	}

	//mới
	@RequestMapping(value = "findByUserID", method = RequestMethod.POST)
	public ResponseEntity<List<User_CourseDTO>> findByUserID(@RequestBody User_CourseDTO dto) {
		try {

			return new ResponseEntity<List<User_CourseDTO>>(iUserCourseService.findByUserID(dto.getUser_id()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<User_CourseDTO>>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "findUserCourseByCourseID", method = RequestMethod.POST)
	public ResponseEntity<User_CourseDTO> findUserCourseByCourseID(@RequestBody User_CourseDTO dto) {
		try {

			return new ResponseEntity<User_CourseDTO>(iUserCourseService.findUserCourseByCourseID(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<User_CourseDTO>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "deleteUserCourse", method = RequestMethod.POST)
	public ResponseEntity<Integer> deleteUserCourse(@RequestBody User_CourseDTO dto) {
		try {

			return new ResponseEntity<Integer>(iUserCourseService.delete(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
	}
}
