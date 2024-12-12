package com.ashutosh.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.bindinig.courseBinding;
import com.ashutosh.entity.courses;
import com.ashutosh.service.service;

@RestController
public class Course_Controller {
	
	 @Autowired
	 service service1;
	
	 @GetMapping("/getAllCourses")
	public List<courseBinding> getAllCourses(){
		List<courseBinding> data = service1.getAllCourses();
		return data;
		 
	}
	
	 @GetMapping("/changeActiveStatus")
	public String  changeActiveStatus(@RequestParam("id")Integer id) {
		 
		     String msg =           service1.activeStatus(id);
		return msg;
		
	}
	 
	 @GetMapping("/enrolled")
	 public List<courses> enrolled(@RequestParam("id")Integer id){
		 List<courses> data = service1.enrolled(id);
		 return data;
	 }
	 
	  @GetMapping("/instructed")
	  public List<courses> instructed(@RequestParam("id")Integer id){
		            List<courses> data = service1.instructCourses(id);
		   return data;
	  }
	
	  @GetMapping("/enroll")
	  public boolean enroll(@RequestParam("studentId") Integer sId,@RequestParam("courseId") Integer cId)
	  {         boolean b =      service1.enroll(sId, cId);
		  return b;
	  }
        
	  @PostMapping("/updateCourse")
	  public boolean updateCourse(@RequestBody courseBinding data) {
		      boolean b =       service1.updateCourse(data);
		  return b;
		  
	  }
	   
		  @PostMapping("/createCourse")
		  public boolean createCourse(@RequestBody courseBinding data) {
			          boolean b =        service1.createCourse(data);
			  return b;
			  
		  }
	  
	  
	  
	  
}
