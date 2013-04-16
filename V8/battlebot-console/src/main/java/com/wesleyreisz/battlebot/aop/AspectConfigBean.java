package com.wesleyreisz.battlebot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectConfigBean {
	@Pointcut("execution(* com.wesleyreisz.battlebot.Battle.*(..))")
	public void adviceMethods() {
	}

	@Around("adviceMethods()")
	public void execute(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		long startTime = System.currentTimeMillis();
		System.out.println("Around method executing...");
		proceedingJoinPoint.proceed();
		System.out.println("Around method complete...");
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Battle Execution time: " + timeTaken + " milliseconds.");
	}
}
