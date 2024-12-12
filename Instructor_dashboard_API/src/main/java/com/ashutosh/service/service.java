package com.ashutosh.service;

import java.util.List;

import com.ashutosh.binding.getFeedBack;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.student;

public interface service {
	
	 public List<student> getEnrolledStudent(Integer courseId);
	 
	 public List<Instructor> getAllInstructor();
	 
	 public List<Instructor>   getActiveInstructors();
	  
	 public boolean addFeedback(com.ashutosh.binding.addFeedback data);
	 
	 public List<getFeedBack> getFeddBack(Integer insId);
	 
	 
	 

}
