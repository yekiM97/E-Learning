package com.myclass.service;

import java.util.List;

import com.myclass.dto.User_CourseDTO;

public interface IUserCourseService {
	List<User_CourseDTO> getListUserCourse();

	User_CourseDTO add(User_CourseDTO dto);

	User_CourseDTO edit(User_CourseDTO dto);

	User_CourseDTO findByID(int id);
	
	User_CourseDTO findUserCourseByCourseID(User_CourseDTO dto);
	
	List<User_CourseDTO> findByUserID(int id);
	
	List<User_CourseDTO> findByCourseID(int courseId, int userId);

	int delete(int id);
}
