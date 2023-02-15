package com.example.crossroad1;

public class Coordinate {
    // grid x and y
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate convertToDP(int x, int y) {
        return new Coordinate((x * 50) + 25, (y * 50) + 25);
    }
}
