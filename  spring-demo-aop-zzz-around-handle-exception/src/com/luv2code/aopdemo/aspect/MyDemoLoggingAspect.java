package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object afterGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>> Executing @Around on method :" + method);

		long begin = System.currentTimeMillis();

		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());

			result = "Major accident! But no worries," + "your Private AOP helicopter is on the way";
			throw e;
		}

		long end = System.currentTimeMillis();

		long duration = end - begin;

		myLogger.info("\n====>> Duration : " + duration / 1000.0 + " miliseconds");
		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>> Executing @After (finally) on method " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "Exc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJointPoint, Throwable Exc) {
		String method = theJointPoint.getSignature().toShortString();
		myLogger.info("\n=====>> Executing @AfterThrowing on method " + method);

		myLogger.info("\n=====>> Excption is " + Exc);
	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountService(JoinPoint theJointPoint, List<Account> result) {

		String method = theJointPoint.getSignature().toShortString();
		myLogger.info("\n=====>> Executing @AfterReturning on method " + method);
		myLogger.info("\n=====>> result is : " + result);

		convertAccountNamesUpperCase(result);
		myLogger.info("\n=====>> result is : " + result);

	}

	private void convertAccountNamesUpperCase(List<Account> result) {
		// TODO Auto-generated method stub

		for (Account acc : result) {
			acc.setName(acc.getName().toUpperCase());
		}

	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		myLogger.info("\n=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("Method: " + methodSig);

		// display method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());

			if (tempArg instanceof Account) {

				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;

				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());

			}
		}

	}

}
