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

/*public class Vehicle {
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
*/
}
