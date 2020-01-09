package com.example.lottery.controller;

import com.example.lottery.model.LotteryModel;
import com.example.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("action")
@RequestScope
@SessionAttributes({"lottery"})
public class LotteryController {
    @Autowired
    private LotteryModel lotteryModel;
    @Autowired
    private LotteryService lotteryService;

    @ModelAttribute("lottery") // JSP: ${lottery}
    public LotteryModel getLotteryModel() {
        return lotteryModel;
    }

    @GetMapping
    public String home(HttpSession session) {
        System.err.println(session.getId());
        return "home";
    }

    @PostMapping("draw")
    public String draw(int n) {
        lotteryModel.getNumbers().addAll(lotteryService.draw(n));
        return "home";
    }

    @PostMapping("reset")
    public String reset() {
        lotteryModel.getNumbers().clear();
        return "home";
    }
}
