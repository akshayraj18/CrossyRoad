package com.example.crossroad1;

public class CarTile extends Tile {

    private Coordinate carCoord1;
    private int carImage;
    private boolean hasCarSprite;

    public CarTile(Coordinate loc) {
        super();
        this.carCoord1 = loc;
        this.carImage = R.drawable.car;
    }

    @Override
    public void setImage(int carImage) {
        if (hasCarSprite) {
            this.carImage = R.drawable.car;
        }
    }

    @Override
    public int getImage() {
        return carImage;
    }

    //@Override
    public void addSprite() {
        hasCarSprite = true;
        this.carImage = R.drawable.car;
    }

    //@Override
    public void removeSprite() {
        hasCarSprite = false;
        this.carImage = R.drawable.road_tile;
    }
}
