package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.Instructor;


public interface instructorRepo extends JpaRepository<Instructor,Integer>  {
	 public Instructor findByEmail(String email);
	 
	    @Query(value = "Select * from Instructors_Data where actvieSt = 'Y'",nativeQuery = true)
	      public List<Instructor> getActiveInsturctor();
}
