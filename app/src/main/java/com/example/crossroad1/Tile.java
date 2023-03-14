package com.example.crossroad1;

public abstract class Tile {
    // grid x and y
    private Coordinate coord;
    private int playerImage;
    private boolean hasPlayerSprite;
    private int tileType;

    private boolean hasCar;
    private boolean hasJet;
    private boolean hasUFO;

    public Tile() {
        tileType = playerImage;
    }

    public Tile(Coordinate coord, int playerImage) {
        this.coord = coord;
        this.playerImage = playerImage;
        tileType = playerImage;
    }

    public int getImage() {
        if (hasPlayerSprite) {
            return ConfigActivity.getPlayer().getImage();
        } else if (hasCar) {
            return R.drawable.delorean_vehicle;
        } else if (hasUFO) {
            return R.drawable.ufo_vehicle;
        } else if (hasJet) {
            return R.drawable.jet_vehicle;
        } else {
            return playerImage;
        }
    }

    public void setImage() {
        if (hasPlayerSprite) {
            this.playerImage = ConfigActivity.getPlayer().getImage();
        } else if (hasCar) {
            this.playerImage = tileType;
        } else if (hasUFO) {
            this.playerImage = tileType;
        } else if (hasJet) {
            this.playerImage = tileType;
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

    public void addCar() {
        hasCar = true;
    }

    public void removeCar() {
        hasCar = false;
    }

    public void addUFO() {
        hasUFO = true;
    }

    public void removeUFO() {
        hasUFO = false;
    }

    public void addJet() {
        hasJet = true;
    }

    public void removeJet() {
        hasJet = false;
    }

    public void setTileType(int type) {
        tileType = type;
    }

}
