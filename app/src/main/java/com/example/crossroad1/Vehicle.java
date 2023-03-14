package com.example.crossroad1;

public abstract class Vehicle {
    private Coordinate coord;
    private int image;

    private final int vehicleType;

    public Vehicle(Coordinate coord, int image) {
        this.coord = coord;
        this.image = image;
        vehicleType = image;
    }

    public void setImage(int image) {
        this.image = vehicleType;
    }

    public void moveLeft() {
        coord.moveLeft();
    }


}
