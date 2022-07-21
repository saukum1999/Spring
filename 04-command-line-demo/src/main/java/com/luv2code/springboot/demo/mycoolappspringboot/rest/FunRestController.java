package com.luv2code.springboot.demo.mycoolappspringboot.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello() {
		return "current time on server is : "+ LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String workout() {
		return "Daily run 5K";
	}
}
