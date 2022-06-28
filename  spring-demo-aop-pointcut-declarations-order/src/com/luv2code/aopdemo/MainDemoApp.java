package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2com.aopdemo.dao.AccountDAO;
import com.luv2com.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMemDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account acc = new Account();
		theDAO.addAccount(acc,true);
		theDAO.doWork();;
		
		theDAO.setName("Hello!!");
		theDAO.setServiceCode("Hello!!");
		
		String s1=theDAO.getName();
		String s2=theDAO.getServiceCode();
//		System.out.println("\nlets run again.....\n");
		
		theMemDAO.addMember();
		theMemDAO.goToSleep();
		
		context.close();
	}
}
