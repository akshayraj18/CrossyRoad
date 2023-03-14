package com.example.crossroad1;

import android.os.Handler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Grid {
    // player coordinates
    private static Coordinate playerCoord;
    private static Coordinate carCoord1;

    private static Coordinate ufoCoord1;

    private static Coordinate jetCoord1;

    private static Coordinate ufoCoord2;

    private static Coordinate jetCoord2;


    private final Tile[] tiles;

    private static int yMax = 11;
    private int playerTile = 84;
    private int jetTile1 = 63;
    private int ufoTile1 = 64;
    private int carTile1 = 79;
    private int ufoTile2 = 48;
    private int jetTile2 = 47;

<<<<<<< HEAD
    Handler handler = new Handler();

    Runnable player = new Runnable() {
        @Override
        public void run() {
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
        }
    };

    Runnable carMove = new Runnable() {
=======
    private Handler handler = new Handler();
    private Runnable carMove = new Runnable() {
>>>>>>> c44be21cae45a55e197ecc6d6dd305841bfaf64c
        @Override
        public void run() {
            // call the update vehicles, tiles, etc.
            if (getCarCoord1().getX() > 0) {
<<<<<<< HEAD
                tiles[carTile1].removeSprite();
                tiles[carTile1].setImage(R.drawable.car);
=======
>>>>>>> c44be21cae45a55e197ecc6d6dd305841bfaf64c
                carCoord1.moveLeft();
                tiles[carTile1].removeCar();
                tiles[carTile1].setImage();
                carTile1 -= 1;
<<<<<<< HEAD
                //tiles[carTile1].addSprite();
                //tiles[carTile1].setImage(R.drawable.car);
                tiles[carTile1] = new CarTile(carCoord1);
                GameActivity.adapter.notifyDataSetChanged();
            } else {
                tiles[carTile1].removeSprite();
                tiles[carTile1].setImage(R.drawable.car);
=======
                tiles[carTile1].addCar();
                tiles[carTile1].setImage();
                GameActivity.getAdapter().notifyDataSetChanged();
            } else {
>>>>>>> c44be21cae45a55e197ecc6d6dd305841bfaf64c
                carCoord1.setX(7);
                carCoord1.setY(10);
                tiles[carTile1].removeCar();
                tiles[carTile1].setImage();
                carTile1 += 7;
<<<<<<< HEAD
                //tiles[carTile1].addSprite();
                //tiles[carTile1].setImage();
                tiles[carTile1] = new CarTile(carCoord1);
                GameActivity.adapter.notifyDataSetChanged();
=======
                tiles[carTile1].addCar();
                tiles[carTile1].setImage();
                GameActivity.getAdapter().notifyDataSetChanged();
>>>>>>> c44be21cae45a55e197ecc6d6dd305841bfaf64c
            }
            handler.postDelayed(this, 1000); // Call the clock again
        }
    };

    Runnable ufoMove = new Runnable() {
        @Override
        public void run() {
            // call the update vehicles, tiles, etc.
            if (getUfoCoord1().getX() < 7) {
                tiles[ufoTile1].removeSprite();
                ufoCoord1.moveRight();
                tiles[ufoTile1].removeUFO();
                tiles[ufoTile1].setImage();
                ufoTile1 += 1;
                tiles[ufoTile1] = new UFOTile(ufoCoord1);
            } else {
                tiles[ufoTile1].removeSprite();
                ufoCoord1.setX(0);
                ufoCoord1.setY(9);
                tiles[ufoTile1].removeUFO();
                tiles[ufoTile1].setImage();
                ufoTile1 -= 7;
                tiles[ufoTile1] = new UFOTile(ufoCoord1);
            }
            if (getUfoCoord2().getX() < 7) {
                tiles[ufoTile2].removeSprite();
                ufoCoord2.moveRight();
                tiles[ufoTile2].removeUFO();
                tiles[ufoTile2].setImage();
                ufoTile2 += 1;
                tiles[ufoTile2] = new UFOTile(ufoCoord2);
            } else {
                tiles[ufoTile2].removeSprite();
                ufoCoord2.setX(0);
                ufoCoord2.setY(7);
                tiles[ufoTile2].removeUFO();
                tiles[ufoTile1].setImage();
                ufoTile2 -= 7;
                tiles[ufoTile2] = new UFOTile(ufoCoord2);
            }
            GameActivity.adapter.notifyDataSetChanged();
            handler.postDelayed(this, 750); // Call the clock again
        }
    };

    Runnable jetMove = new Runnable() {
        @Override
        public void run() {
            // call the update vehicles, tiles, etc.
            if (getJetCoord1().getX() > 0) {
                tiles[jetTile1].removeSprite();
                jetCoord1.moveLeft();
                tiles[jetTile1].removeJet();
                tiles[jetTile1].setImage();
                jetTile1 -= 1;
                tiles[jetTile1] = new JetTile(jetCoord1);
            } else {
                tiles[jetTile1].removeSprite();
                jetCoord1.setX(7);
                jetCoord1.setY(8);
                tiles[jetTile1].removeJet();
                tiles[jetTile1].setImage();
                jetTile1 += 7;
                tiles[jetTile1] = new JetTile(jetCoord1);
            }
            if (getJetCoord2().getX() > 0) {
                tiles[jetTile2].removeSprite();
                jetCoord2.moveLeft();
                tiles[jetTile2].removeJet();
                tiles[jetTile2].setImage();
                jetTile2 -= 1;
                tiles[jetTile2] = new JetTile(jetCoord2);
            } else {
                tiles[jetTile2].removeSprite();
                jetCoord2.setX(7);
                jetCoord2.setY(6);
                tiles[jetTile2].removeJet();
                tiles[jetTile2].setImage();
                jetTile2 += 7;
                tiles[jetTile2] = new JetTile(jetCoord2);
            }
            GameActivity.adapter.notifyDataSetChanged();
            handler.postDelayed(this, 500); // Call the clock again
        }
    };




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
        tiles[carTile1] = new CarTile(new Coordinate(7, 10));
        tiles[ufoTile1] = new UFOTile(new Coordinate(0, 9));
        tiles[jetTile1] = new JetTile(new Coordinate(7, 8));
        tiles[ufoTile2] = new UFOTile(new Coordinate(0,7));
        tiles[jetTile2] = new JetTile(new Coordinate(7,6));
        playerCoord = new Coordinate(4, 11);
        carCoord1 = new Coordinate(7, 10);
        ufoCoord1 = new Coordinate(0,9);
        jetCoord1 = new Coordinate(7,8);
        ufoCoord2 = new Coordinate(0,7);
        jetCoord2 = new Coordinate(7,6);

    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Tile getTile(int x, int y) {
        return tiles[x + (y - 1) * 8];
    }

    public static Coordinate getPlayerCoord() {
        return playerCoord;
    }

    public static Coordinate getCarCoord1() {
        return carCoord1;
    }

    public static Coordinate getUfoCoord1() {
        return ufoCoord1;
    }

    public static Coordinate getUfoCoord2() {
        return ufoCoord2;
    }

    public static Coordinate getJetCoord1() {
        return jetCoord1;
    }

    public static Coordinate getJetCoord2() {
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
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
            playerTile -= 1;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
        }
    }

    public void moveRight() {
        if (getPlayerCoord().getX() < 7) {
            playerCoord.moveRight();
            tiles[playerTile].removeSprite();
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
            playerTile += 1;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
        }
    }

    public void moveUp() {
        if (getPlayerCoord().getY() > 1) {
            playerCoord.moveUp();
            tiles[playerTile].removeSprite();
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
            playerTile -= 8;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
            if (Grid.getPlayerCoord().getY() < Grid.getYMax()) {
                if (Grid.getYMax() == 11) {
                    Player.setPoints(100);
                } else if (Grid.getYMax() == 10 || Grid.getYMax() == 8) {
                    Player.setPoints(200);
                } else if (Grid.getYMax() == 9 || Grid.getYMax() == 7) {
                    Player.setPoints(300);
                } else {
                    Player.setPoints(50);
                }
                Grid.updateyMax();
            }
        }

    }

    public void moveDown() {
        if (getPlayerCoord().getY() < 11) {
            playerCoord.moveDown();
            tiles[playerTile].removeSprite();
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
            playerTile += 8;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage(ConfigActivity.getPlayer().getImage());
        }

    }


}
