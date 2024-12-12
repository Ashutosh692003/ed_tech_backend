package com.ashutosh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class AuthService {
	
	;
	
	 @Autowired
	private PasswordEncoder passwordEncoder;
	 
	 @Autowired
	 private jwtService jwtService;
	
	
	
	
	public String generateToken(String userName) {
		return jwtService.generateToken(userName);
	}
	public String validateToken(String token) {
		 jwtService.validateToken(token);
		 return "token is valid";
	}

	
	
	
}
