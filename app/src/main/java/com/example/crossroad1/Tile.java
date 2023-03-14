package com.example.crossroad1;

public abstract class Tile {
    // grid x and y
    private Coordinate coord;
    private int playerImage;
    private boolean hasPlayerSprite;
    private final int tileType;

    public Tile(Coordinate coord, int playerImage) {
        this.coord = coord;
        this.playerImage = playerImage;
        tileType = playerImage;
    }

    public int getImage() {
        return hasPlayerSprite ? ConfigActivity.getPlayer().getImage() : playerImage;
    }

    public void setImage() {
        if (hasPlayerSprite) {
            this.playerImage = ConfigActivity.getPlayer().getImage();
        } else {
            this.playerImage = tileType;
        }
    }

    public boolean hasSprite() {
        return hasPlayerSprite;
    }

    public void addSprite() {
        hasPlayerSprite = true;
    }

    public void removeSprite() {
        hasPlayerSprite = false;
    }
}
