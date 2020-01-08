package com.example.imdb;

import java.util.stream.IntStream;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.imdb.service.impl.BusinessService;

public class LotteryApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = new AnnotationConfigApplicationContext("com.example.imdb.config",
				"com.example.imdb.service.impl");
		BusinessService srv = container.getBean(BusinessService.class);
		IntStream.range(0, 10).forEach(i -> srv.gun());

		container.close();
	}
}
