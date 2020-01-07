package com.example.imdb.service.impl;

import org.springframework.beans.factory.annotation.Value;

public class BusinessService {
	@Value("${message}") // SpEL
	private String message;

	public void fun() {
		System.out.println(message);
	}
}
