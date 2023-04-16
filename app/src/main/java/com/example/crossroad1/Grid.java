package com.example.crossroad1;


import com.example.crossroad1.activities.GameActivity;
import com.example.crossroad1.tiles.CloudTile;
import com.example.crossroad1.tiles.IslandTile;
import com.example.crossroad1.tiles.SkyTile;
import com.example.crossroad1.tiles.StreamTile;


public class Grid {
    // player coordinates
    private Coordinate playerCoord;
    private  Coordinate carCoord1;

    private  Coordinate ufoCoord1;

    private Coordinate jetCoord1;

    private  Coordinate ufoCoord2;

    private  Coordinate jetCoord2;

    private Coordinate logCoord1;
    private Coordinate logCoord2;
    private Coordinate logCoord3;


    private final Tile[] tiles;

    private static int yMax = 11;
    private int playerTile = 84;
    private int jetTile1 = 63;
    private int ufoTile1 = 64;
    private int carTile1 = 79;
    private int ufoTile2 = 48;
    private int jetTile2 = 47;

    private int log1 = 28; // starts 3rd row to right
    private int log3 = 12; //left
    private int log2 = 20; //left

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
        tiles[log1].addLog();
        tiles[log2].addLog();
        tiles[log3].addLog();
        playerCoord = new Coordinate(4, 11);
        carCoord1 = new Coordinate(7,  10);
        ufoCoord1 = new Coordinate(0, 9);
        jetCoord1 = new Coordinate(7, 8);
        ufoCoord2 = new Coordinate(0, 7);
        jetCoord2 = new Coordinate(7, 6);
        logCoord1 = new Coordinate(4, 3);
        logCoord2 = new Coordinate(4, 2);
        logCoord3 = new Coordinate(4, 1);
    }

    public void carRun() {
        // call the update vehicles, tiles, etc.
        if (getCarCoord1().getX() > 0) {
            carCoord1.moveLeft();
            moveVehicleTile(carTile1);
            GameActivity.getAdapter().notifyDataSetChanged();
        } else {
            carCoord1.setX(7);
            carCoord1.setY(10);
            resetVehicleTile(carTile1);
            GameActivity.getAdapter().notifyDataSetChanged();
        }
    }

    public void ufoRun() {
        if (getUfoCoord1().getX() < 7) {
            ufoCoord1.moveRight();
            moveVehicleTile(ufoTile1);
        } else {
            ufoCoord1.setX(0);
            ufoCoord1.setY(9);
            resetVehicleTile(ufoTile1);
        }
        if (getUfoCoord2().getX() < 7) {
            ufoCoord2.moveRight();
            moveVehicleTile(ufoTile2);
        } else {
            ufoCoord2.setX(0);
            ufoCoord2.setY(7);
            resetVehicleTile(ufoTile2);
        }
        GameActivity.getAdapter().notifyDataSetChanged();
    }

    public void jetLeftUpdate1() {
        jetCoord1.moveLeft();
        moveVehicleTile(jetTile1);
    }

    public void jetLeftReset1() {
        jetCoord1.setX(7);
        jetCoord1.setY(8);
        resetVehicleTile(jetTile1);
    }

    public void jetLeftReset2() {
        jetCoord2.setX(7);
        jetCoord2.setY(6);
        resetVehicleTile(jetTile2);
    }

    public void jetLeftUpdate2() {
        jetCoord2.moveLeft();
        moveVehicleTile(jetTile2);
    }
    public void jetRun() {
        if (getJetCoord1().getX() > 0) {
            jetLeftUpdate1();
        } else {
            jetLeftReset1();
        }
        if (getJetCoord2().getX() > 0) {
            jetLeftUpdate2();
        } else {
            jetLeftReset2();
        }
        GameActivity.getAdapter().notifyDataSetChanged();
    }
    public void log1Run() { // make sure to move the player too if it is on the log
        if (getLogCoord1().getX() > 0) {
            if (log1 == playerTile) {
                playerCoord.moveLeft();
                tiles[playerTile].removeSprite();
                tiles[playerTile].setImage();
                playerTile -= 1;
                tiles[playerTile].addSprite();
                tiles[playerTile].setImage();
            }
            logCoord1.moveLeft();
            tiles[log1].removeLog();
            tiles[log1].setImage();
            log1 -= 1;
            tiles[log1].addLog();
            tiles[log1].setImage();
            GameActivity.getAdapter().notifyDataSetChanged();
        } else { // not updating player automatically kills them
            logCoord1.setX(7);
            tiles[log1].removeLog();
            tiles[log1].setImage();
            log1 += 7;
            tiles[log1].addLog();
            tiles[log1].setImage();
            GameActivity.getAdapter().notifyDataSetChanged();
        }
    }

    public void log2Run() { // make sure to move the player too if it is on the log
        if (getLogCoord2().getX() < 7) {
            if (log2 == playerTile) {
                playerCoord.moveRight();
                tiles[playerTile].removeSprite();
                tiles[playerTile].setImage();
                playerTile += 1;
                tiles[playerTile].addSprite();
                tiles[playerTile].setImage();
            }
            logCoord2.moveRight();
            tiles[log2].removeLog();
            tiles[log2].setImage();
            log2 += 1;
            tiles[log2].addLog();
            tiles[log2].setImage();
            GameActivity.getAdapter().notifyDataSetChanged();
        } else { // not updating player automatically kills them
            logCoord2.setX(0);
            tiles[log2].removeLog();
            tiles[log2].setImage();
            log2 -= 7;
            tiles[log2].addLog();
            tiles[log2].setImage();
            GameActivity.getAdapter().notifyDataSetChanged();
        }
    }

    public void log3Run() { // make sure to move the player too if it is on the log
        if (getLogCoord3().getX() < 7) {
            if (log3 == playerTile) {
                playerCoord.moveRight();
                tiles[playerTile].removeSprite();
                tiles[playerTile].setImage();
                playerTile += 1;
                tiles[playerTile].addSprite();
                tiles[playerTile].setImage();
            }
            logCoord3.moveRight();
            tiles[log3].removeLog();
            tiles[log3].setImage();
            log3 += 1;
            tiles[log3].addLog();
            tiles[log3].setImage();
            GameActivity.getAdapter().notifyDataSetChanged();
        } else { // not updating player automatically kills them
            logCoord3.setX(0);
            tiles[log3].removeLog();
            tiles[log3].setImage();
            log3 -= 7;
            tiles[log3].addLog();
            tiles[log3].setImage();
            GameActivity.getAdapter().notifyDataSetChanged();
        }
    }

    /*public void logRun(int logNumber) {
        if ((logNumber == 2 && getLogCoord2().getX() < 7) || (logNumber == 3 &&
        getLogCoord3().getX() < 7)) {
            if ((log2 == playerTile || log3 == playerTile) && getPlayerCoord().getX() < 7) {
                playerCoord.moveRight();
                tiles[playerTile].removeSprite();
                tiles[playerTile].setImage();
                playerTile += 1;
                tiles[playerTile].addSprite();
                tiles[playerTile].setImage();
            }
            if (logNumber == 2) {
                logCoord2.moveRight();
                tiles[log2].removeLog();
                tiles[log2].setImage();
                log2 += 1;
                tiles[log2].addLog();
                tiles[log2].setImage();
                GameActivity.getAdapter().notifyDataSetChanged();
            } else {
                logCoord3.moveRight();
                tiles[log3].removeLog();
                tiles[log3].setImage();
                log3 += 1;
                tiles[log3].addLog();
                tiles[log3].setImage();
                GameActivity.getAdapter().notifyDataSetChanged();
            }
            GameActivity.getAdapter().notifyDataSetChanged();
        } else {
            if (logNumber == 2) {
                logCoord2.setX(0);
                tiles[log2].removeLog();
                tiles[log2].setImage();
                log2 -= 7;
                tiles[log2].addLog();
                tiles[log2].setImage();
            } else {
                logCoord3.setX(0);
                tiles[log3].removeLog();
                tiles[log3].setImage();
                log3 -= 7;
                tiles[log3].addLog();
                tiles[log3].setImage();
            }
        }
    }

    public void log2Run() {
        logRun(2);
    }
    public void log3Run() {
        logRun(3);
    }*/


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

    public Coordinate getLogCoord1() {
        return logCoord1;
    }

    public Coordinate getLogCoord2() {
        return logCoord2;
    }

    public Coordinate getLogCoord3() {
        return logCoord3;
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

    public void resetPlayer() {
        playerTile = 84;
        playerCoord.setX(4);
        playerCoord.setY(11);
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
                } else if (playerTile < 8) {
                    Player.incPoints(5000);
                } else {
                    Player.incPoints(50);
                }
                Grid.updateyMax();
            }
        }
    }

    public void resetVehicleTile(int tile) {
        if (tile == 40 || tile == 56) {
            tiles[tile].removeJet();
            tiles[tile].setImage();
            if (tile == 40) {
                jetTile2 += 7;
            } else {
                jetTile1 += 7;
            }
            tiles[tile + 7].addJet();
            tiles[tile + 7].setImage();
        } else if (tile == 55 || tile == 71) {
            tiles[tile].removeUFO();
            tiles[tile].setImage();
            if (tile == 55) {
                ufoTile2 -= 7;
            } else {
                ufoTile1 -= 7;
            }
            tiles[tile - 7].addUFO();
            tiles[tile - 7].setImage();
        } else {
            tiles[tile].removeCar();
            tiles[tile].setImage();
            carTile1 += 7;
            tiles[tile + 7].addCar();
            tiles[tile + 7].setImage();
        }
    }
    public void moveVehicleTile(int tile) {
        if (40 <= tile && tile < 48 || 56 <= tile && tile < 64) {
            tiles[tile].removeJet();
            tiles[tile].setImage();
            tiles[--tile].addJet();
            tiles[tile].setImage();
            if (tile < 48) {
                jetTile2--;
            } else {
                jetTile1--;
            }
        } else if (72 <= tile && tile < 80) {
            tiles[tile].removeCar();
            tiles[tile].setImage();
            tiles[--tile].addCar();
            tiles[tile].setImage();
            carTile1--;
        } else if (47 < tile && tile <= 55 || 63 < tile && tile <= 71) {
            tiles[tile].removeUFO();
            tiles[tile].setImage();
            tiles[++tile].addUFO();
            tiles[tile].setImage();
            if (tile > 63) {
                ufoTile1++;
            } else {
                ufoTile2++;
            }
        }
    }

    public boolean hasCollision() {
        return tiles[playerTile].hasVehicle();
    }

    public boolean inWater() {
        return (tiles[playerTile] instanceof StreamTile && !tiles[playerTile].hasLog());
    }

    public boolean reachedGoal() {
        return (tiles[playerTile] instanceof IslandTile);
    }
}
