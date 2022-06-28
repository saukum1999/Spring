package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
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
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println(" =======> Executing @MyDemoLoggingAspect ..... ");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method : " + methodSig);
		
		
		Object[] args = theJoinPoint.getArgs();
		for (Object object : args) {
			System.out.println(object);
			
//			if(object instanceof Account) {
//				Account acc = (Account) object;
//				acc.toString();
//			}
		}
	}

//	@Before("forDaoPackageNoGetterSetter()")
//	public void performApiAnalytics() {
//		System.out.println(" =======> Performing API Analytics ....");
//	}
}
