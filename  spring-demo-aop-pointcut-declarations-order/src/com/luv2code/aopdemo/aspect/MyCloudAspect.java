package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAspect {

	@Before("execution(* com.luv2com.aopdemo.dao.*.*(..))")
	public void performApiAnalytics() {
		System.out.println(" =======> Performing Cloud Aspect ....");
	}
}
