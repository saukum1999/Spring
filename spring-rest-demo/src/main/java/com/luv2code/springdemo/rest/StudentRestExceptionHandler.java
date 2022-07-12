package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResposne> handleException (StudentNotFoundException exc){
		
		StudentErrorResposne error = new StudentErrorResposne();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
//	Generic Exception Handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResposne> handleException (Exception exc){
		
		StudentErrorResposne error = new StudentErrorResposne();
		
		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
	}
}
