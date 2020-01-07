package com.example.imdb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProfileAspect {
//	@Before
//	@AfterReturning
//	@AfterThrowing
//	@After
	@Around("execution(* *.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long stop = System.nanoTime();
		System.out.println(String.format("%s runs %d ns.", pjp.getSignature().getName(), (stop - start)));
		return result;
	}
}
