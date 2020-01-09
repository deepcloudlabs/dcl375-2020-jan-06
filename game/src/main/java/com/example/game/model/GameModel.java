package com.example.game.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@SessionScope
public class GameModel {
    private int secret;
    private int tries;
    private List<Move> moves = new ArrayList<>();

    public GameModel() {
        tries = 0;
        secret = ThreadLocalRandom.current().nextInt(0, 100) + 1;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void play(int guess) {
        if (guess == secret) {
            moves.clear();
            tries = 0;
            moves.add(new Move(guess, "You win!"));
            secret = ThreadLocalRandom.current().nextInt(0, 100) + 1;
        } else {
            tries++;
            if (tries > 7) {
                moves.clear();
                tries = 0;
                moves.add(new Move(secret, "You lose!"));
                secret = ThreadLocalRandom.current().nextInt(0, 100) + 1;
            } else {
                String message = evaluateGuess(guess);
                moves.add(new Move(guess,message));
            }
        }
    }

    private String evaluateGuess(int guess) {
        if (guess<secret) return "Pick larger!";
        return "Pick smaller!";
    }
}
