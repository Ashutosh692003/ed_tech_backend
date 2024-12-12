package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.entity.Course_Category;

public interface categoryRepo extends JpaRepository<Course_Category,Integer>{
  
@Query(value = "Select * from Course_Category where Category_name=?1",nativeQuery = true)
	 public Course_Category findByName(String name);
}
