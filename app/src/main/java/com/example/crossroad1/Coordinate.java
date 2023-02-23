package com.example.crossroad1;

public class Coordinate {
    // grid x and y
    static int x;
    static int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft() {
        this.x -= 1;
    }

    public void moveRight() {
        this.x += 1;
    }

    public void moveUp() {
        this.y += 1;
    }

    public void moveDown() {
        this.y -= 1;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}
