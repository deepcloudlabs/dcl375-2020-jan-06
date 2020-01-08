package com.example.imdb.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;

import com.example.imdb.aop.Profiler;

public class BusinessService {
	@Value("${message}") // SpEL
	private String message;

	@Profiler(unit = TimeUnit.MICROSECONDS)
	public void fun() {
		System.out.println(message);
	}
}
