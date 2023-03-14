package com.example.crossroad1;

public class UFOTile extends Tile {
    private Coordinate ufoCoord;
    private int ufoImage;
    private boolean hasUfoSprite;

    public UFOTile(Coordinate loc) {
        super();
        this.ufoCoord = loc;
        this.ufoImage = R.drawable.ufo;
        super.setTileType(ufoImage);
    }

    @Override
    public void setImage() {
        if (hasUfoSprite) {
            this.ufoImage = R.drawable.ufo;
        }
    }

    @Override
    public int getImage() {
        return ufoImage;
    }

    public void addSprite() {
        this.ufoImage = R.drawable.ufo;
    }

    public void removeSprite() {
        this.ufoImage = R.drawable.road_tile;
    }
}
