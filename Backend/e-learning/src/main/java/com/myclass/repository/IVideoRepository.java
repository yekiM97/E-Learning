package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.*;

@Repository
public interface IVideoRepository extends JpaRepository<Video, Integer>{

	@Query("select v from Video v where course_id = :courseId")
	List<Video> findByCourseID(@Param("courseId")int courseId);
}
