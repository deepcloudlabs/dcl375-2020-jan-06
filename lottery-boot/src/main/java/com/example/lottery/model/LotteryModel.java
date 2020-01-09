package com.example.lottery.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class LotteryModel {
    private List<List<Integer>> numbers = new ArrayList<>();

    public LotteryModel() {
    }

    //region setter/getter
    public List<List<Integer>> getNumbers() {
        return numbers;
    }
    //endregion
}
