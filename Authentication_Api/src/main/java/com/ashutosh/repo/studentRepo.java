package com.ashutosh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.Admin;
import com.ashutosh.entity.student;

public interface studentRepo extends JpaRepository<student,Integer>  {
	
	 public Optional<student> findByEmail(String email);

}
