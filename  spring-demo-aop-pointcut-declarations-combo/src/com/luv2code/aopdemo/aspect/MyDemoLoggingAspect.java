package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.luv2com.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution(* com.luv2com.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution (* com.luv2com.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() ||setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =======> Executing @Before ..... ");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println(" =======> Performing API Analytics ....");
	}
}
