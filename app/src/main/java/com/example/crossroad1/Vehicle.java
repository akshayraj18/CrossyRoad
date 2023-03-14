package com.example.crossroad1;

public class Vehicle {
    private String name;
    private VehicleSprite vehicleSprite;
    private int image;

    public Vehicle(String name, VehicleSprite vehicleSprite) {
        this.name = name;
        this.vehicleSprite = vehicleSprite;
        if (vehicleSprite == VehicleSprite.CAR) {
            image = R.drawable.car;
        } else if (vehicleSprite == VehicleSprite.UFO) {
            image = R.drawable.ufo;
        } else if (vehicleSprite == VehicleSprite.JET){
            image = R.drawable.jet;
        }
    }

    public String getName() {
        return name;
    }

    public VehicleSprite getVehicleSprite() {
        return vehicleSprite;
    }

    public int getImage() {
        return image;
    }

}
