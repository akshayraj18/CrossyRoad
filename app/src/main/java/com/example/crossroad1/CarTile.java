package com.example.crossroad1;

public class CarTile extends Tile {

    private Coordinate carCoord1;
    private int carImage;
    private boolean hasCarSprite;

    public CarTile(Coordinate loc) {
        super();
        this.carCoord1 = loc;
        this.carImage = R.drawable.car;
        super.setTileType(carImage);
    }


    @Override
    public void setImage() {
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
        this.carImage = R.drawable.car;
    }

    //@Override
    public void removeSprite() {
        this.carImage = R.drawable.road_tile;
    }
}
