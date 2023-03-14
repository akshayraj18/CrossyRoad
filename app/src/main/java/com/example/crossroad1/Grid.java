package com.example.crossroad1;

public class Grid {
    // player coordinates
    private static Coordinate playerCoord;
    private final Tile[] tiles;

    private static int yMax = 11;
    private int playerTile = 84;
    private int jetTile = 63;
    private int ufoTile = 64;
    private int carTile = 79;


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
        tiles[jetTile] = new JetTile(new Coordinate(7, 8));
        tiles[ufoTile] = new UFOTile(new Coordinate(0, 9));
        tiles[carTile] = new CarTile(new Coordinate(7, 10));
        playerCoord = new Coordinate(4, 11);
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
            if (Grid.getPlayerCoord().getY() < Grid.getYMax()) {
                if (Grid.getYMax() == 11) {
                    Player.setPoints(100);
                } else if (Grid.getYMax() == 10) {
                    Player.setPoints(200);
                } else if (Grid.getYMax() == 9) {
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
            tiles[playerTile].setImage();
            playerTile += 8;
            tiles[playerTile].addSprite();
            tiles[playerTile].setImage();
        }

    }
}
