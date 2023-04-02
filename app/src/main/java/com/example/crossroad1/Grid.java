package com.example.crossroad1;

import android.content.Intent;
import android.os.Handler;

import com.example.crossroad1.activities.ConfigActivity;
import com.example.crossroad1.activities.EndActivity;
import com.example.crossroad1.activities.GameActivity;
import com.example.crossroad1.tiles.CloudTile;
import com.example.crossroad1.tiles.IslandTile;
import com.example.crossroad1.tiles.SkyTile;
import com.example.crossroad1.tiles.StreamTile;


public class Grid {
    // player coordinates
    private Coordinate playerCoord;
    private Coordinate carCoord1;

    private Coordinate ufoCoord1;

    private Coordinate jetCoord1;

    private Coordinate ufoCoord2;

    private Coordinate jetCoord2;


    private final Tile[] tiles;

    private static int yMax = 11;
    private int playerTile = 84;
    private int jetTile1 = 63;
    private int ufoTile1 = 64;
    private int carTile1 = 79;
    private int ufoTile2 = 48;
    private int jetTile2 = 47;


    public void carRun() {
        // call the update vehicles, tiles, etc.
        if (getCarCoord1().getX() > 0) {
            carCoord1.moveLeft();
            tiles[carTile1].removeCar();
            tiles[carTile1].setImage();
            carTile1 -= 1;
            tiles[carTile1].addCar();
            tiles[carTile1].setImage();
            GameActivity.getAdapter().notifyDataSetChanged();
        } else {
            carCoord1.setX(7);
            carCoord1.setY(10);
            tiles[carTile1].removeCar();
            tiles[carTile1].setImage();
            carTile1 += 7;
            tiles[carTile1].addCar();
            tiles[carTile1].setImage();
            GameActivity.getAdapter().notifyDataSetChanged();
        }
//        handler.postDelayed(this, 1000); // Call the clock again
    }
    public void ufoRun() {
        if (getUfoCoord1().getX() < 7) {
            ufoCoord1.moveRight();
            tiles[ufoTile1].removeUFO();
            tiles[ufoTile1].setImage();
            ufoTile1 += 1;
            tiles[ufoTile1].addUFO();
            tiles[ufoTile1].setImage();
        } else {
            ufoCoord1.setX(0);
            ufoCoord1.setY(9);
            tiles[ufoTile1].removeUFO();
            tiles[ufoTile1].setImage();
            ufoTile1 -= 7;
            tiles[ufoTile1].addUFO();
            tiles[ufoTile1].setImage();
        }
        if (getUfoCoord2().getX() < 7) {
            ufoCoord2.moveRight();
            tiles[ufoTile2].removeUFO();
            tiles[ufoTile2].setImage();
            ufoTile2 += 1;
            tiles[ufoTile2].addUFO();
            tiles[ufoTile2].setImage();
        } else {
            ufoCoord2.setX(0);
            ufoCoord2.setY(7);
            tiles[ufoTile2].removeUFO();
            tiles[ufoTile1].setImage();
            ufoTile2 -= 7;
            tiles[ufoTile2].addUFO();
            tiles[ufoTile2].setImage();
        }
        GameActivity.getAdapter().notifyDataSetChanged();
    }
    public void jetRun() {
        if (getJetCoord1().getX() > 0) {
            jetCoord1.moveLeft();
            tiles[jetTile1].removeJet();
            tiles[jetTile1].setImage();
            jetTile1 -= 1;
            tiles[jetTile1].addJet();
            tiles[jetTile1].setImage();
        } else {
            jetCoord1.setX(7);
            jetCoord1.setY(8);
            tiles[jetTile1].removeJet();
            tiles[jetTile1].setImage();
            jetTile1 += 7;
            tiles[jetTile1].addJet();
            tiles[jetTile1].setImage();
        }
        if (getJetCoord2().getX() > 0) {
            jetCoord2.moveLeft();
            tiles[jetTile2].removeJet();
            tiles[jetTile2].setImage();
            jetTile2 -= 1;
            tiles[jetTile2].addJet();
            tiles[jetTile2].setImage();
        } else {
            jetCoord2.setX(7);
            jetCoord2.setY(6);
            tiles[jetTile2].removeJet();
            tiles[jetTile2].setImage();
            jetTile2 += 7;
            tiles[jetTile2].addJet();
            tiles[jetTile2].setImage();
        }
        GameActivity.getAdapter().notifyDataSetChanged();
    }


    public Grid() {
        tiles = new Tile[8 * 11]; // cols*rows
        // goal: 0
        // safe: 1
        // river: 2-3
        //safe: 4
        //road: 5-7
        //river: 8-9
        //safe: 10
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 8; c++) {
                if (r == 4 || r == 10) {
                    // safe: cloud
                    tiles[r * 8 + c] = new CloudTile(new Coordinate(r, c));
                } else if (r == 1 || r == 2 || r == 3) {
                    // river: stream
                    tiles[r * 8 + c] = new StreamTile(new Coordinate(r, c));
                } else if (r == 0) {
                    //goal: island
                    tiles[r * 8 + c] = new IslandTile(new Coordinate(r, c));
                } else {
                    //road: sky
                    tiles[r * 8 + c] = new SkyTile(new Coordinate(r, c));
                }
            }
        }
        tiles[playerTile].addSprite();
        tiles[carTile1].addCar();
        tiles[ufoTile1].addUFO();
        tiles[ufoTile2].addUFO();
        tiles[jetTile1].addJet();
        tiles[jetTile2].addJet();
        playerCoord = new Coordinate(4, 11);
        carCoord1 = new Coordinate(7,  10);
        ufoCoord1 = new Coordinate(0, 9);
        jetCoord1 = new Coordinate(7, 8);
        ufoCoord2 = new Coordinate(0, 7);
        jetCoord2 = new Coordinate(7, 6);

    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Tile getTile(int x, int y) {
        return tiles[x + (y - 1) * 8];
    }

    public Coordinate getPlayerCoord() {
        return playerCoord;
    }

    public Coordinate getCarCoord1() {
        return carCoord1;
    }

    public Coordinate getUfoCoord1() {
        return ufoCoord1;
    }

    public Coordinate getUfoCoord2() {
        return ufoCoord2;
    }

    public Coordinate getJetCoord1() {
        return jetCoord1;
    }

    public Coordinate getJetCoord2() {
        return jetCoord2;
    }

    public static int getYMax() {
        return yMax;
    }

    public static void updateyMax() {
        yMax -= 1;
    }

    public static void resetYMax() {
        yMax = 11;
    }

    public int getTile() {
        return playerTile;
    }

    // player movement needed for sprint 1
    // process for not going outside of grid
    // called depending onKeyPress
    // Note: these methods are not done
    public void moveLeft() {
        if (getPlayerCoord().getX() > 0) {
            playerCoord.moveLeft();
            tiles[playerTile].removeSprite();
            tiles[playerTile].setImage();
            playerTile -= 1;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage();
        }
    }

    public void moveRight() {
        if (getPlayerCoord().getX() < 7) {
            playerCoord.moveRight();
            tiles[playerTile].removeSprite();
            tiles[playerTile].setImage();
            playerTile += 1;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage();
        }
    }

    public void moveUp() {
        if (getPlayerCoord().getY() > 1) {
            playerCoord.moveUp();
            tiles[playerTile].removeSprite();
            tiles[playerTile].setImage();
            playerTile -= 8;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage();
            if (this.getPlayerCoord().getY() < Grid.getYMax()) {
                if (Grid.getYMax() == 11) {
                    Player.incPoints(100);
                } else if (Grid.getYMax() == 10 || Grid.getYMax() == 8) {
                    Player.incPoints(200);
                } else if (Grid.getYMax() == 9 || Grid.getYMax() == 7) {
                    Player.incPoints(300);
                } else {
                    Player.incPoints(50);
                }
                Grid.updateyMax();
            }
        }
    }

    public void moveDown() {
        if (getPlayerCoord().getY() < 11) {
            playerCoord.moveDown();
            tiles[playerTile].removeSprite();
            tiles[playerTile].setImage();
            playerTile += 8;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage();
        }
    }

    public boolean hasCollision() {
        return tiles[playerTile].hasVehicle();
    }

    public boolean inWater() {
        return (tiles[playerTile] instanceof StreamTile);
    }
}
