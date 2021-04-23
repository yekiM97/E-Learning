package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Target;

@Repository
public interface ITargetRepository extends JpaRepository<Target, Integer>{
	@Query("Select t from Target t where course_id = :courseId")
	public List<Target> findTargetByCourseID(@Param("courseId") int courseId);
}
