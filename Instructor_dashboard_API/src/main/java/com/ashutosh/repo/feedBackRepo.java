package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.feedback_instructor_data;

public interface feedBackRepo extends JpaRepository<feedback_instructor_data,Integer> {
	

	   public List<feedback_instructor_data>  findByInstructorId(Integer id);
}
