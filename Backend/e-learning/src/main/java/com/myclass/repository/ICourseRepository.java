package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer>{

//	@Query("select c from Course c and User_Course uc where uc.course_id = :courseId and c.id = uc.course_id")
//	List<Course> getListCourseByCourseId(@Param("courseId")int courseId);
}
