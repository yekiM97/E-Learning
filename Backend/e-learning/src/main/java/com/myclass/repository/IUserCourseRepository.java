package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.dto.User_CourseDTO;
import com.myclass.entity.User_Course;

@Repository
public interface IUserCourseRepository extends JpaRepository<User_Course, Integer>{

	@Query("select v from User_Course v where user_id = :userId")
	List<User_Course> findByUserID(@Param("userId")int userId);
	
	@Query("select v from User_Course v where course_id = :courseId and user_id= :userId")
	List<User_Course> findByCourseID(@Param("courseId")int courseId,@Param("userId")int userId);
}
