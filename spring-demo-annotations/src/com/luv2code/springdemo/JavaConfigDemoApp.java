package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortuneService());
		
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		context.close();

	}

}
