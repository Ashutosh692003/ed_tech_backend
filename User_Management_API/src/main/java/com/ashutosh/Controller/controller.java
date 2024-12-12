package com.ashutosh.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.binding.forgotPassword;
import com.ashutosh.binding.forgotPasswordStart;
import com.ashutosh.binding.signUpStudent;
import com.ashutosh.entity.Instructor;
import com.ashutosh.entity.student;
import com.ashutosh.service.service;

@RestController
public class controller {
	
	 @Autowired
	 service s;
         
	   @PostMapping("/forgot")
	public ResponseEntity<String> forgotPwd(@RequestBody forgotPasswordStart f) {
		     
		String str =      s.forgotStart(f);
		return new ResponseEntity<>(str,HttpStatus.OK);
		    
		   
	   }
	   
	   @PostMapping("/signUp")
	   public ResponseEntity<String> signUp( @RequestBody signUpStudent details){
		boolean b =     s.signUp(details) ;
		return new ResponseEntity<>("Account Created Successfully",HttpStatus.CREATED);
		
	   }
	   
	   @PostMapping("/update")
	   public ResponseEntity<String> updatePassword( @RequestBody com.ashutosh.binding.updatePassword up){
		      String resp =  s.updatePassword(up);
		      return new ResponseEntity<>(resp,HttpStatus.OK);
		   
		   
	   }
	   
	   @PostMapping("/updateStudent")
	   public boolean updateStudent(@RequestBody com.ashutosh.binding.updateStudent details) {
		  boolean b =     s.updateStudent(details);
		  return b;
	   }
	   @PostMapping("/updateInstructor")
	   public boolean updateStudent( @RequestBody com.ashutosh.binding.updateInstructor details) {
		  boolean b =     s.updateInstructor(details);
		  return b;
	   }
	   @PostMapping("/recovery")
	   public ResponseEntity<String> recovery(@RequestBody forgotPassword details){
		   String resp =      s.forgot(details);
		   return new ResponseEntity<>(resp,HttpStatus.OK);
	   }
	   @GetMapping("/test")
	   public String test() {
		    return "Yes it is working";
	   }
	   
	   @GetMapping("/changeVisibilityStudent")
	   public String changeVisibilityS(@RequestParam("sid") Integer sid) {
		    String msg=         s.changeVisiblityStudent(sid);
		    return msg;
	   }
	   
	   @GetMapping("/changeVisibilityInstructor")
	   public String changeVisibilityIns(@RequestParam("insId") Integer id) {
		    String msg=       s.chnageVisiblityIns(id);
		    return msg;
	   }
	   
	    @GetMapping("/getStudentDetail")
	   public student getStudentDetails(@RequestParam("sId") Integer sid) {
		    student stu =     s.getStudentDetail(sid);
		     return stu;
	   }
	    @GetMapping("/getInstructorDetail")
	    public Instructor getInstructorDetail(@RequestParam("insId") Integer insId) {
	    	Instructor ins = s.getInstructorDetail(insId);
	    	return ins;
	    }
	    
}
