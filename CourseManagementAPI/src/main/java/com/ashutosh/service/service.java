package com.ashutosh.service;

import java.util.List;

import com.ashutosh.bindinig.courseBinding;
import com.ashutosh.entity.courses;
import com.ashutosh.entity.trending;

public interface service {
	
	 public List<courses> getActiveCourses();
	 
	 public List<courseBinding> getAllCourses();
	 
	 public  String  activeStatus(Integer id);
	 
	 public boolean updateCourse(courseBinding data);
	 
	 public boolean createCourse(courseBinding data);
	 
	 public  List<courses> enrolled(Integer id);
	 
	 public List<courses> instructCourses(Integer id);
	 
	 public boolean  enroll(Integer studentId,Integer courseId);
	 
	 
	 
	 
	
	 
	 
	 

}
