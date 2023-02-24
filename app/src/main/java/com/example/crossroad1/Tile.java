package com.example.crossroad1;

public abstract class Tile {
    // grid x and y
    private Coordinate coord;
    private int image;
    private boolean hasSprite;

    private final int tileType;

    public Tile(Coordinate coord, int image) {
        this.coord = coord;
        this.image = image;
        tileType = image;
    }

    public int getImage() {
        return hasSprite ? ConfigActivity.getPlayer().getImage() : image;
    }

    public void setImage() {
        if (hasSprite) {
            this.image = ConfigActivity.getPlayer().getImage();
        } else {
            this.image = tileType;
        }
    }

    public boolean hasSprite() {
        return hasSprite;
    }

    public void addSprite() {
        hasSprite = true;
    }

    public void removeSprite() {
        hasSprite = false;
    }
}
