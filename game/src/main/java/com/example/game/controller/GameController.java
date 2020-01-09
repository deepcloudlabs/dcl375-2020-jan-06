package com.example.game.controller;

import com.example.game.model.GameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestScope
@RequestMapping("action")
@SessionAttributes({"game"})
public class GameController {
    @Autowired
    private GameModel game;

    @ModelAttribute("game")
    public GameModel getGame() {
        return game;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping("play")
    public String play(int guess) {
        game.play(guess);
        return "home";
    }
}
