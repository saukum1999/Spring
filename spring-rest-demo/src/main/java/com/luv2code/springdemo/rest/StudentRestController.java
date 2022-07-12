package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima","Patel"));
		theStudents.add(new Student("Hema","Malini"));
		theStudents.add(new Student("Rekha","Jayant"));
		theStudents.add(new Student("Jaya","Jhata"));
	}

	@GetMapping("/students")
	public List<Student> getStudents(){
				
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
//		check the studentId against the students list
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student Id not found - "+studentId);
		}
				
		return theStudents.get(studentId);
		
	}
	
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
