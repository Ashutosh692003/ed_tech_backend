package com.ashutosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.binding.adminCreation;
import com.ashutosh.binding.adminUpdate;
import com.ashutosh.binding.communicationBinding;
import com.ashutosh.entity.Transaction;
import com.ashutosh.service.service;

@RestController
public class Controller {
	
	 @Autowired
	  service serv;
	
	         @PostMapping("/insAccCreation")
	      public ResponseEntity<String> insAccCreation(@RequestBody adminCreation data) {
	        	  
	    String resp	 =  serv.insAccCreation(data);
	       return new ResponseEntity<>(resp,HttpStatus.OK);
	      }
	         

	         @PostMapping("/adminAccCreation")
	      public ResponseEntity<String> adminAccCreation(@RequestBody adminCreation data) {
	        	  
	    String resp	 =  serv.adminAccCreation(data);
	       return new ResponseEntity<>(resp,HttpStatus.OK);
	      }
	         
	         @PostMapping("/adminAccUpdate")
		      public ResponseEntity<String> adminAccUpdate(@RequestBody adminUpdate data) {
		        	  
		    String resp	 =  serv.adminAccUpdate(data);
		       return new ResponseEntity<>(resp,HttpStatus.OK);
		      }
	         @PostMapping("/communication")
		      public boolean adminAccCreation(@RequestBody communicationBinding data) {
		        	  
		    boolean resp	 =  serv.communicate(data);
		       return resp;
		      }
	         
	         @GetMapping("/changeVisibilityAdmin")
	         public ResponseEntity<String> changeVisibility(Integer id) {
	        String resp=	  serv.changeVisibilityAdmin(id);
	        return new ResponseEntity<>(resp,HttpStatus.OK);
	        	 
	         }
	         
	        @GetMapping("getLastTransactions")
	        public List<Transaction> getLastTransaction(){
	       List<Transaction>  trans = 	 serv.getLastTransaction();
	       return trans;
	        }
	         
	 

}
