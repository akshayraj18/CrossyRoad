package com.example.crossroad1;

public class Player {
    int lives;
    int points;
    String name;
    Sprite sprite; // path to sprite image
    Difficulty difficulty;

    public Player(String name, Sprite sprite, Difficulty difficulty) {
        if (name == null || name.trim().length() == 0) {
            throw new InvalidNameException();
            // currently runtime exception, make it handle exception later on and make it checked
        }
        this.name = name;
        this.sprite = sprite;
        this.lives = difficulty.ordinal() + 1; // hard is 1 lives, medium is 2, easy is 3
        this.difficulty = difficulty;
        this.points = 0;
    }
}
