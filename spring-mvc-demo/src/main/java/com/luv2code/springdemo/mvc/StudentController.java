package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student")
@Controller
public class StudentController {
	@RequestMapping("/showForm")
	public String studentData(Model theModel ) {
		theModel.addAttribute("student", new Student());
		return "student_form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println(theStudent.getFirstName() + theStudent.getLastName());
		
		return "student_conformation";
	}
}