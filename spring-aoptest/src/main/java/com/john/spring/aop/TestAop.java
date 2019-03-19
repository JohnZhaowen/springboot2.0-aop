package com.john.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class TestAop {

	@Pointcut("execution(* com.john.spring.controller.TestController.test1(..))")
	public void point() {
	}

	
	@Before(value="point() && args(name)", argNames="name") 
	public void before(JoinPoint point, String name) throws Throwable {
		MethodInvocationProceedingJoinPoint jpoint = (MethodInvocationProceedingJoinPoint)point; 
		Object[] args = jpoint.getArgs();
		args[0] = "demo";
	
		System.out.println("before..."); 
	}
	
	 
	 @After("point()") public void after(JoinPoint point) {
	 System.out.println("after..."); }
	 
	 
	 @AfterReturning(value="point()", returning="result") 
	 public void afterReturning(JoinPoint point, String result) {
		 System.out.println("after returning..."); 
	 }
	 
	 
	 @AfterThrowing(value="point()", throwing="ex") 
	 public void afterThrowing(JoinPoint point, Throwable ex) {
		 System.out.println("after throwing..."); 
	 }
	 
	
	  @Around("point()") 
	  public void around(ProceedingJoinPoint point) throws Throwable {
		  Object[] args = point.getArgs();
		  point.proceed(args);
		  point.proceed();
		  
		  args[0] = "demo";
		  
		  point.proceed(args);
	  }


}
