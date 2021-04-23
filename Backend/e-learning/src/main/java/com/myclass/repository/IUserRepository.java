package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query("Select u from User u where u.email = :email")
	public User findByEmail(@Param("email") String email);
}
