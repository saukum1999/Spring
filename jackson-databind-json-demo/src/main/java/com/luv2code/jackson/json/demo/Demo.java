package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Demo {
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			Student stud = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println("Firstname : "+ stud.getFirstName() );
			System.out.println("Lastname : "+ stud.getLastName() );
			System.out.println(stud);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
