package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ashutosh.entity.Instructor;


public interface instructorRepo extends JpaRepository<Instructor,Integer>  {
	 public Instructor findByEmail(String email);
}
