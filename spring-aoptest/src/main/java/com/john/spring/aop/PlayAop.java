package com.john.spring.aop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PlayAop {
	
	private static Map<Integer, Integer> num = new ConcurrentHashMap<>();
	
	@Pointcut("execution(* com.john.spring.controller.service.DiskService.play(..))")
	public void playPoint() {}
//	@Pointcut("execution(* com.john.spring.controller.service.impl.DiskServiceImpl.play(..))")
//	public void playPoint() {}
//	
//	@Before("playPoint()")
//	public void count(JoinPoint point) {
//		MethodInvocationProceedingJoinPoint join = (MethodInvocationProceedingJoinPoint)point;
//		Object[] args = join.getArgs();
//		Integer integer = num.get((Integer)args[0]);
//		if(integer == null) {
//			num.put((Integer)args[0], 1);
//		} else {
//			num.put((Integer)args[0], integer + 1);
//		}
//		
//	}
	
	@Before("playPoint() && args(trace)")
	public void count(JoinPoint point, Integer trace) {
		Integer integer = num.get(trace);
		if(integer == null) {
			num.put(trace, 1);
		} else {
			num.put(trace, integer + 1);
		}
		
	}
	
	public static int getCount(int trace) {
		return num.get(trace) == null ? 0 : num.get(trace);
	}
	
	
}
