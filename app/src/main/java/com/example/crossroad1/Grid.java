package com.example.crossroad1;

public class Grid {
    // player coordinates
    private Coordinate playerCoord;
    private Tile[] tiles;

    private static int tile = 84;
    public Grid() {
        tiles = new Tile[8*11]; // cols*rows
        // manual creation, change if you want later
        // goal: 0
        // safe: 1
        // river: 2-3
        //safe: 4
        //road: 5-7
        //river: 8-9
        //safe: 10
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 8; c++) {
                if (r == 4 || r == 10){
                    // safe: cloud
                    tiles[r * 8 + c] = new CloudTile(new Coordinate(r, c));
                }
                else if (r == 2 || r ==3 || r == 8 || r == 9){
                    // river: stream
                    tiles[r * 8 + c] = new StreamTile(new Coordinate(r, c));
                }
                else if (r == 0){
                    //goal: island
                    tiles[r * 8 + c] = new IslandTile(new Coordinate(r, c));
                }
                else {
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

    public Tile getTile(Coordinate coord) {
        return getTile(coord.x, coord.y);
    }

    public Coordinate getPlayerCoord() {
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
      playerCoord.moveLeft();
      tiles[tile].removeSprite();
      tiles[tile].getImage();
      tile -= 1;
      tiles[tile].addSprite();
      tiles[tile].getImage();
    }
//    public void moveRight() {
//        playerCoord = new Coordinate(playerCoord.x + 1,  playerCoord.y);
//    }
//    public void moveUp() {
//        playerCoord = new Coordinate(playerCoord.x - 1,  playerCoord.y + 1);
//    }
//    public void MoveDown() {
//        playerCoord = new Coordinate(playerCoord.x,  playerCoord.y - 1);
//    }


    // future sprint stuff
    // public update; moves moving obstacles each second
    //on update, if sprite is on obstacle, call moveLeft to move player left with obstacle
}
