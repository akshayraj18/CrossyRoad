package com.example.crossroad1;

import org.junit.Test;
import static org.junit.Assert.*;

public class Sprite2UnitTests {
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
    public void upOutOfBoundsCheck() {
        for (int i = 0; i <= 10; i++) {
            grid.moveUp();
        }
        assertEquals(1, grid.getPlayerCoord().getY());
    }

    @Test
    public void downOutOfBoundsCheck() {
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

    @Test
    public void checkSprite() {
        Player p1 = new Player("goat", Sprite.MJ, Difficulty.EASY);
        assertEquals(Sprite.MJ, p1.getSprite());
    }

    @Test
    public void checkLives() {
        Player p1 = new Player("goat", Sprite.MJ, Difficulty.EASY);
        assertEquals(3, p1.getLives());
    }
}
