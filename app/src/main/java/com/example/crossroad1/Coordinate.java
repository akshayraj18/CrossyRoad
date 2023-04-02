package com.example.crossroad1;
public class Coordinate {
    // grid x and y
    private int x;
    private int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
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
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

