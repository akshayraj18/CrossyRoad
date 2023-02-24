package com.example.crossroad1;

public class Grid {
    // player coordinates
    private static Coordinate playerCoord;
    private final Tile[] tiles;

    private static int tile = 84;
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
                } else if (r == 2 || r == 3 || r == 8 || r == 9) {
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
        tiles[tile].addSprite();
        playerCoord = new Coordinate(4, 11);
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Tile getTile(int x, int y) {
        return tiles[x * 8 + y];
    }

    public static Coordinate getPlayerCoord() {
        return playerCoord;
    }

    public static int getTile() {
        return tile;
    }

    // player movement needed for sprint 1
    // process for not going outside of grid
    // called depending onKeyPress
    // Note: these methods are not done
    public void moveLeft() {
        if (getPlayerCoord().getX() > 0) {
            playerCoord.moveLeft();
            tiles[tile].removeSprite();
            tiles[tile].setImage();
            tile -= 1;
            tiles[tile].addSprite();
            tiles[tile].setImage();
        }
    }

    public void moveRight() {
        if (getPlayerCoord().getX() < 7) {
            playerCoord.moveRight();
            tiles[tile].removeSprite();
            tiles[tile].setImage();
            tile += 1;
            tiles[tile].addSprite();
            tiles[tile].setImage();
        }
    }

    public void moveUp() {
        if (getPlayerCoord().getY() > 1) {
            playerCoord.moveUp();
            tiles[tile].removeSprite();
            tiles[tile].setImage();
            tile -= 8;
            tiles[tile].addSprite();
            tiles[tile].setImage();
        }

    }

    public void moveDown() {
        if (getPlayerCoord().getY() < 11) {
            playerCoord.moveDown();
            tiles[tile].removeSprite();
            tiles[tile].setImage();
            tile += 8;
            tiles[tile].addSprite();
            tiles[tile].setImage();
        }

    }
}
