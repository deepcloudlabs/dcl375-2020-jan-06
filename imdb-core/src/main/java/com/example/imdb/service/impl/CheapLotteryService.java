package com.example.imdb.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.imdb.service.LotteryService;
import com.example.imdb.service.Quality;
import com.example.imdb.service.ServiceLevel;

@Service
@Quality(ServiceLevel.CHEAP)
public class CheapLotteryService implements LotteryService {

	@Override
	public List<Integer> draw(int max, int size) {
		return Arrays.asList(1,11,21,32,41,42);
	}

}
