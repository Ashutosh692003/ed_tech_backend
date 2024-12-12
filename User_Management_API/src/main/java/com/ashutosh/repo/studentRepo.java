package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.Admin;
import com.ashutosh.entity.student;

public interface studentRepo extends JpaRepository<student,Integer>  {
	
	 public student findByEmail(String email);

}
