package com.ashutosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.binding.addFeedback;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.student;
import com.ashutosh.service.service;

@RestController
public class controller {
	
	 @Autowired
	 service serv;
	 
	
	 @GetMapping("/getEnrolledStudent")
	 public List<student> getEnrolledStudent(@RequestParam("id")Integer courseId){
		 List<student> data = serv.getEnrolledStudent(courseId);
		 return data;
		 
	 }
	 
	 @GetMapping("/getAllInstructor")
	 public List<Instructor> getAllInstructor(){
	 List<Instructor> data  = serv.getAllInstructor();
	 return data;
	 }
	 
	 @GetMapping("/getActiveInstructors")
	 public List<Instructor> getActiveInstructors(){
		  List<Instructor> data = serv.getActiveInstructors();
		 return data;
		 
	 }
	 
	 @PostMapping("/addFeddBack")
	 public boolean addFeedBack(@RequestBody addFeedback data) {
		boolean b=     serv.addFeedback(data);
		return b;
	 }
	 @GetMapping("/getFeedBack")
	 public List<com.ashutosh.binding.getFeedBack> getFeedBack(@RequestParam("insId") Integer insId){
		List<com.ashutosh.binding.getFeedBack>   data =     serv.getFeddBack(insId);
		 return data;
		 
	 }
	 
	 

}
