package com.ashutosh.service;

import com.ashutosh.binding.forgotPassword;
import com.ashutosh.binding.forgotPasswordStart;
import com.ashutosh.binding.signUpStudent;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.student;

public interface service {
	
	 public String  forgot(forgotPassword details);
	 
	 public String forgotStart(forgotPasswordStart details);
	 
	 public boolean signUp(signUpStudent details);
	 
	 public  boolean updateInstructor(com.ashutosh.binding.updateInstructor details);
	 
	 public boolean updateStudent(com.ashutosh.binding.updateStudent details);
	 
	 public String  updatePassword(com.ashutosh.binding.updatePassword details);
	 
	 public String changeVisiblityStudent(Integer id);
	 
	 public String chnageVisiblityIns(Integer id);
	 
	 public student getStudentDetail(Integer sid);
	 
	 public Instructor getInstructorDetail(Integer insId);
	 
	 
	 
	

}
