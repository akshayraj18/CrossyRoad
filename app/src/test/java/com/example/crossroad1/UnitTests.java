package com.example.crossroad1;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests {
    private Grid grid = new Grid();

    @Test
    public void canMoveLeft() {
        grid.moveLeft();
        assertEquals(3, grid.getPlayerCoord().getX());
    }

    @Test
    public void canMoveRight() {
        grid.moveRight();
        assertEquals(5, grid.getPlayerCoord().getX());
    }

    @Test
    public void canMoveUp() {
        grid.moveUp();
        assertEquals(10, grid.getPlayerCoord().getY());
    }

    @Test
    public void canMoveDown() {
        grid.moveUp();
        grid.moveDown();
        assertEquals(11, grid.getPlayerCoord().getY());
    }

    @Test
    public void leftOutOfBoundsCheck() {
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        assertEquals(0, grid.getPlayerCoord().getX());
        grid.moveLeft();
        assertEquals(0, grid.getPlayerCoord().getX());
        grid.moveRight();
        grid.moveLeft();
        assertEquals(0, grid.getPlayerCoord().getX());

    }

    @Test
    public void rightOutOfBoundsCheck() {
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        assertEquals(7, grid.getPlayerCoord().getX());
        grid.moveRight();
        assertEquals(7, grid.getPlayerCoord().getX());
        grid.moveLeft();
        grid.moveRight();
        assertEquals(7, grid.getPlayerCoord().getX());
    }

    @Test
    public void checkCombinationSpriteMovement1() {
        grid.moveRight();
        grid.moveUp();
        grid.moveLeft();
        grid.moveRight();
        grid.moveUp();
        grid.moveRight();
        grid.moveDown();
        grid.moveLeft();
        assertEquals(5, grid.getPlayerCoord().getX());
        assertEquals(10, grid.getPlayerCoord().getY());
    }

    @Test
    public void checkCombinationSpriteMovement2() {
        grid.moveRight();
        grid.moveUp();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveUp();
        grid.moveLeft();
        grid.moveDown();
        grid.moveRight();
        grid.moveUp();
        grid.moveRight();
        grid.moveUp();
        grid.moveLeft();
        assertEquals(3, grid.getPlayerCoord().getX());
        assertEquals(8, grid.getPlayerCoord().getY());
    }
}
