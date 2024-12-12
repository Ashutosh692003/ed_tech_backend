package com.ashutosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.dto.AuthRequest;

import com.ashutosh.service.AuthService;

@RestController
@RequestMapping("/auth")
public class authController {

	 @Autowired
	private AuthService auth;
	 @Autowired
	 private AuthenticationManager authManager;
	 
	 @PostMapping("/token")
	 public String getToken(@RequestBody AuthRequest authCred) {
		
		
		 
	Authentication authenticate = 	 authManager.authenticate(new UsernamePasswordAuthenticationToken(authCred.getUsername(),authCred.getPassword()));
		 
	if(authenticate.isAuthenticated()) {
	String token = auth.generateToken(authCred.getUsername());

	return token;}
		  
		  else {
			   throw new RuntimeException("Invalid Access");
		  }
	 }
	 
	 @GetMapping("/validate")
	 public String getToken(@RequestParam("token")String token) {
		   auth.validateToken(token);
		   System.out.println("No Excpetion");
		   return "Token is valid";

	 }
	 
	 
}
