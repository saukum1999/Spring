package com.luv2code.springboot.demo.mycoolappspringboot.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teamInfo")
	public String getInfo() {
		return "\n Coach Name : "+coachName +"\n Team Name : "+teamName;
	}
	
	
	@GetMapping("/")
	public String sayHello() {
		return "current time on server is : "+ LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String workout() {
		return "Daily run 5K";
	}
}
