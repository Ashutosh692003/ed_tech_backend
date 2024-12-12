package com.ashutosh.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class Handler {
      
	 @ExceptionHandler(Exception.class)
	public ResponseEntity<format> handler(Exception e) {
		 String message = e.getMessage();
		 format f = new format();
		 f.setMsg(message);
		 f.setCode("user_m_1");
		 f.setTime(LocalDateTime.now());
		 
		 return new ResponseEntity<>(f,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
