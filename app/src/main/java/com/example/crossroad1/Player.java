package com.example.crossroad1;

import com.example.crossroad1.enums.Difficulty;
import com.example.crossroad1.enums.Sprite;

public class Player {
    private static int lives;
    private static int points;
    private static String name;
    private static Sprite sprite;
    private static Difficulty difficulty;
    private static int image;

    public Player(String name, Sprite sprite, Difficulty difficulty) {
        this.name = name;
        this.sprite = sprite;
        this.lives = difficulty.ordinal() + 1; // hard is 1 lives, medium is 2, easy is 3
        this.difficulty = difficulty;
        this.points = 0;
        if (sprite == Sprite.MJ) {
            image = R.drawable.jordan;
        } else if (sprite == Sprite.LBJ) {
            image = R.drawable.lebron;
        } else {
            image = R.drawable.shaq;
        }
    }

    public static int getLives() {
        return lives;
    }

    public static int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public static Sprite getSprite() {
        return sprite;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getImage() {
        return image;
    }

    public static void setPoints(int x) {
        points = x;
    }
    public static void incPoints(int x) {
        points += x;
    }

    public static void setLives(int x) {
        lives = x;
    }

    public void decLives() {
        lives -= 1;
    }

}
