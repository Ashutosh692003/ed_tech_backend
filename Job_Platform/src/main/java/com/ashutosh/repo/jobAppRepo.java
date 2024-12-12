 package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.Job;
import com.ashutosh.entity.jobApplication;

public interface jobAppRepo  extends JpaRepository<jobApplication,Integer>{
	 @Query(value = "SELECT * FROM Job Application Data WHERE studentId=?1 ", nativeQuery = true)  
	  List<Job> getAppliedJobData(Integer id);
}
