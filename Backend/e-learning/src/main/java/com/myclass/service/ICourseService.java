package com.myclass.service;

import java.util.List;

import com.myclass.dto.CourseDTO;

public interface ICourseService {
	List<CourseDTO> getListCourse();

	List<CourseDTO> getListCourseByID(int id);
	
	

	CourseDTO add(CourseDTO dto);

	CourseDTO edit(CourseDTO dto);

	CourseDTO findByID(int id);

	int delete(int id);

}
