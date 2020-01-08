package com.example.imdb.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.imdb.service.LotteryService;
import com.example.imdb.service.Quality;
import com.example.imdb.service.ServiceLevel;

@Service
@Quality(ServiceLevel.SIMPLE)
public class SimpleLotteryService implements LotteryService {

	@Override
	public List<Integer> draw(int max, int size) {
		return Arrays.asList(1,2,3,4,5,6);
	}

}
