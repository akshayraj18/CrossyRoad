package com.example.crossroad1;

import com.example.crossroad1.activities.ConfigActivity;
import com.example.crossroad1.enums.Sprite;

public abstract class Tile {
    // grid x and y
    private Coordinate coord;
    private int playerImage;
    private boolean hasPlayerSprite;
<<<<<<< HEAD
    private int tileType;
=======
    protected int tileType;

>>>>>>> f6f1785652cae4e3c0928234307a1f515a235a14
    private boolean hasCar;
    private boolean hasJet;
    private boolean hasUFO;
    private boolean hasLog;

    public Tile() {
        tileType = playerImage;
    }

    public Tile(Coordinate coord, int playerImage) {
        this.coord = coord;
        this.playerImage = playerImage;
        tileType = playerImage;
    }

    public int getImage() {
        if (hasPlayerSprite && !hasLog) {
            return ConfigActivity.getPlayer().getImage();
        } else if (hasPlayerSprite && hasLog) {
            Sprite sprite = Player.getSprite();
            if (sprite == Sprite.MJ) {
                return R.drawable.logj;
            } else if (sprite == Sprite.LBJ) {
                return R.drawable.logl;
            } else {
                return R.drawable.logs;
            }
        } else if (hasLog) {
            return R.drawable.log;
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

    public void setImage(int playerImage) {
        if (hasPlayerSprite) {
<<<<<<< HEAD
            this.playerImage = playerImage;
=======
            this.playerImage = ConfigActivity.getPlayer().getImage();
<<<<<<< HEAD
        }  else {
=======
        } else if (hasCar) {
            this.playerImage = tileType;
        } else if (hasUFO) {
            this.playerImage = tileType;
        } else if (hasJet) {
            this.playerImage = tileType;
>>>>>>> c44be21cae45a55e197ecc6d6dd305841bfaf64c
        } else {
>>>>>>> f6f1785652cae4e3c0928234307a1f515a235a14
            this.playerImage = tileType;
        }
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

    public void addLog() {
        hasLog = true;
    }

    public void removeLog() {
        hasLog = false;
    }

    public void setTileType(int type) {
        tileType = type;
    }

    public boolean hasVehicle() {
        return hasCar || hasJet || hasUFO;
    }

    public boolean hasLog() {
        return hasLog;
    }

}
