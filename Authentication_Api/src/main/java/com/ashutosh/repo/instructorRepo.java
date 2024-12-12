package com.ashutosh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.Admin;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.student;

public interface instructorRepo extends JpaRepository<Instructor,Integer>  {
	 public Optional<Instructor >findByEmail(String email);
}
