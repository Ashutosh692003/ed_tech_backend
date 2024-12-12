package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.Job;

public interface jobRepo extends JpaRepository<Job,Integer> {
	
	 @Query(value = "Select * from Job_Data where jobStatus ='Active'",nativeQuery = true)
	public List<Job> getActiveJob();
	 
	 @Query(value = "SELECT * FROM Job_Data WHERE salary BETWEEN ?1 AND ?2", nativeQuery = true)
	    List<Job> findBySalaryRange(Integer lowerBound, Integer upperBound);
	 
	 @Query(value = "SELECT * FROM Job_Data WHERE  employmentType=?1", nativeQuery = true)
	    List<Job> findByEmploymentType(String type);
	 
	 @Query(value = "SELECT * FROM Job_Data WHERE  domain=?1", nativeQuery = true)
	    List<Job> findByDomain(String domain);
	 
	 


	
}
