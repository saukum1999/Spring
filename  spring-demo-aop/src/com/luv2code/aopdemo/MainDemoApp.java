package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2com.aopdemo.dao.AccountDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theDAO = context.getBean("accountDAO",AccountDAO.class);
		
		theDAO.addAccount();
		
		System.out.println("\nlets run again.....\n");
		
		theDAO.addAccount();
		
		
		context.close();
	}
}
