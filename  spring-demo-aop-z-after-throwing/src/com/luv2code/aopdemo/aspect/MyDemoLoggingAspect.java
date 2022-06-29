package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="Exc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJointPoint, Throwable Exc) {
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\n=====>> Executing @AfterThrowing on method " + method);
		
		System.out.println("\n=====>> Excption is " + Exc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountService(JoinPoint theJointPoint, List<Account> result) {
		
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\n=====>> Executing @AfterReturning on method "+ method);
		System.out.println("\n=====>> result is : " + result);

		convertAccountNamesUpperCase(result);
		System.out.println("\n=====>> result is : " + result);
		
	}
	
	private void convertAccountNamesUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		
		for(Account acc : result) {
			acc.setName(acc.getName().toUpperCase());
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>>> Executing @Before advice on method");	
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());								

			}
		}
		
	}
	
}










