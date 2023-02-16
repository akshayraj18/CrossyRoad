package com.example.crossroad1;

public abstract class Tile {
    // grid x and y
    private Coordinate coord;
    private int image;
    private boolean hasSprite;

    public Tile(Coordinate coord, int image) {
        this.coord = coord;
        this.image = image;
    }

    public int getImage() {
        return hasSprite ? ConfigActivity.getPlayer().getImage(): image;
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
