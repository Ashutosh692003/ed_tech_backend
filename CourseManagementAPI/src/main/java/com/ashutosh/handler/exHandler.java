package com.ashutosh.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class exHandler {
	
	 @ExceptionHandler(Exception.class)
	public ResponseEntity<format> handler(Exception e){
		
		 format form =new format();
		  String msg  = e.getMessage();
		  form.setMsg(msg);
		  form.setCode("cm-101");
		  form.setTime(LocalDateTime.now());
		  
		  return new ResponseEntity<>(form,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
