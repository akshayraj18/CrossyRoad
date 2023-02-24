package com.example.crossroad1;

public class Coordinate {
    // grid x and y
    public static int x;
    public static int y;

    public Coordinate(int x, int y) {
        Coordinate.x = x;
        Coordinate.y = y;
    }

    public void moveLeft() {
        x -= 1;
    }

    public void moveRight() {
        x += 1;
    }

    public void moveUp() {
        y -= 1;
    }

    public void moveDown() {
        y += 1;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}
