package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		
		// get membership bean from spring container
		List<Account> theAccounts = null;
		try {
			boolean tripwire = false;
		theAccounts = theAccountDAO.findAccounts(tripwire);
		}
		catch(Exception e) {
			 System.out.println("\n\nMain Program .. Caught exception: "+ e);
		}
		// close the context
		System.out.println("\n\nMain Program AfterThrowingDemoApp...............");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		
		context.close();
	}

}
