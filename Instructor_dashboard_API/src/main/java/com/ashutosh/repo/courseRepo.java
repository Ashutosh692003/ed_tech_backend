package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.courses;

public interface courseRepo extends JpaRepository<courses,Integer>  {
	
	@Query(value = "SELECT * FROM Course_Data WHERE activeSt = 'Y'", nativeQuery = true)
	public List<courses> getActiveCourses();
	

    @Query(value = "SELECT * Course_Data WHERE courseType = ?1 AND activeSt = 'Y'", nativeQuery = true)
    List<courses> findByCourseType(String courseType);

    @Query(value = "SELECT * FROM Course_Data WHERE courseName LIKE %?1% AND activeSt = 'Y'", nativeQuery = true)
    List<courses> findByCourseName(String courseName);

}
