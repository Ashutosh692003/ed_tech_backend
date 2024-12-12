package com.ashutosh.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class excepHandler {

	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<format> exHandle(Exception e){
		    format data  = new format();
		     data.setMsg(e.getMessage());
		     data.setCode("INDB-1");
		     data.setTime(LocalDateTime.now());
		     
		    return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
}
