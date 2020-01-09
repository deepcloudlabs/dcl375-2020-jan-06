package com.example.game.model;

public class Move {
    private int guess;
    private String message;

    public Move() {
    }

    public Move(int guess, String message) {
        this.guess = guess;
        this.message = message;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
