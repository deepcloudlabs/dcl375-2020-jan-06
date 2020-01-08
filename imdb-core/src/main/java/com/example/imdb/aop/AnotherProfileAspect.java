package com.example.imdb.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnotherProfileAspect {
	@Around("@annotation(profiler)")
	public Object profileMethod(ProceedingJoinPoint pjp, 
			Profiler profiler) throws Throwable {
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long stop = System.nanoTime();
		String methodName = pjp.getSignature().getName() + "*";
		TimeUnit tu = profiler.unit();
		long duration = stop - start;
		long converted = tu.convert(duration, TimeUnit.NANOSECONDS);
		System.err.println(methodName + " runs at " + converted + " " + tu.name());
		return result;
	}

	@Around("@within(profiler)")
	public Object profileClass(ProceedingJoinPoint pjp, Profiler profiler) throws Throwable {
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long stop = System.nanoTime();
		String methodName = pjp.getSignature().getName();
		TimeUnit tu = profiler.unit();
		long duration = stop - start;
		long converted = tu.convert(duration, TimeUnit.NANOSECONDS);
		System.err.println(methodName + " runs at " + converted + " " + tu.name());
		return result;
	}

}
