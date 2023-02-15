package com.example.crossroad1;
import java.util.HashMap;

public class Grid {
    // player coordinates
    private Coordinate playerCoord;

    HashMap<Coordinate, Tile> tiles; // holds tile object at each coordinate

    // public update; moves moving obstacles each second
    //on update, if sprite is on obstacle, call moveLeft to move player left with obstacle

    // player movement needed for sprint 1
    // process for not going outside of view
    // called depending onKeyPress
    public void moveLeft() {
       playerCoord = new Coordinate(playerCoord.x - 1,  playerCoord.y);
    }
    public void moveRight() {
        playerCoord = new Coordinate(playerCoord.x + 1,  playerCoord.y);
    }
    public void moveUp() {
        playerCoord = new Coordinate(playerCoord.x - 1,  playerCoord.y + 1);
    }
    public void MoveDown() {
        playerCoord = new Coordinate(playerCoord.x,  playerCoord.y - 1);
    }
}
