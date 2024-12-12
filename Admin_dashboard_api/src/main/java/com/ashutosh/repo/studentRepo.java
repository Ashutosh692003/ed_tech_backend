package com.ashutosh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashutosh.entity.courses;
import com.ashutosh.entity.student;

public interface studentRepo extends JpaRepository<student,Integer>  {
	
	 public student findByEmail(String email);
	 
	 @Query( value = "SELECT s FROM Student_Data s WHERE :course MEMBER OF s.courses.courseId",nativeQuery = true)
	 public List<student> findByCoursesContaining(@Param("course") Integer course);
          
	 


}
