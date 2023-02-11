package com.example.crossroad1;

public class Player {
    private int lives;
    private int points;
    private String name;
    private Sprite sprite;
    private Difficulty difficulty;

    public Player(String name, Sprite sprite, Difficulty difficulty) {
        this.name = name;
        this.sprite = sprite;
        this.lives = difficulty.ordinal() + 1; // hard is 1 lives, medium is 2, easy is 3
        this.difficulty = difficulty;
        this.points = 0;
    }

    public int getLives() {
        return lives;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
