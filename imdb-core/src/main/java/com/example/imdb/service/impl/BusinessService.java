package com.example.imdb.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.imdb.aop.Profiler;
import com.example.imdb.service.LotteryService;

@Service
public class BusinessService {
	@Value("${message}") // SpEL
	private String message;
	@Autowired
	private List<LotteryService> lotteryServices;
	private int counter;
	
	@Profiler(unit = TimeUnit.MICROSECONDS)
	public void fun() {
		System.out.println(message);
	}
	private LotteryService getLotteryService() {
		int size = lotteryServices.size();
		return lotteryServices.get(counter++%size);
	}
	public void gun() {
		System.out.println(
				getLotteryService().draw(50, 6));
	}
}
