package com.example.lottery.service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class LotteryService {
    public Collection<List<Integer>> draw(int n) {
        return IntStream.range(0,n)
                .mapToObj( i -> this.draw())
                .collect(Collectors.toList());
    }
    public List<Integer> draw(){
        return ThreadLocalRandom.current()
                .ints(1,50)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }
}
