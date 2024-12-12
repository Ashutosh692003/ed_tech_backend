package com.ashutosh.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.binding.paymentBinding;
import com.ashutosh.service.service;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class controller {
	
	 @Autowired
	 service s;
	
	@GetMapping("/makePayment")
	  public String makePayment(@RequestParam("amount") Integer amount,@RequestParam("courseId") Integer courseId,@RequestParam("studentId")Integer studentId) throws Exception {
		
		         String order =     s.makePayment(amount,courseId,studentId);
		         return order;
		
		
	
	  }
	@PostMapping("/addTransaction")
	public boolean addTransaction( @RequestBody paymentBinding data) {
		
		     boolean b=     s.addTransaction(data);
		     return b;
		
	}
	
	

}
