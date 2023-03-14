package com.example.crossroad1;

import org.junit.Test;
import static org.junit.Assert.*;


public class SprintThreeUnitTests {
    private Grid grid = new Grid();

    @Test
    public void scoreIncreasesUpwards1() {
        grid.moveUp();
        assertEquals(100, Player.getPoints());
    }

    @Test
    public void scoreIncreasesUpwards2() {
        grid.moveUp();
        grid.moveLeft();
        grid.moveUp();
        assertEquals(300, Player.getPoints());
    }

    @Test
    public void scoreIncreasesUpwards3() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveDown();
        grid.moveRight();
        grid.moveUp();
        grid.moveLeft();
        assertEquals(600, Player.getPoints());
    }

    @Test
    public void checkYMax() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveLeft();
        grid.moveDown();
        grid.moveRight();
        assertEquals(8, Grid.getYMax());
    }

    @Test
    public void checkCarRow() {
        assertEquals(10, Grid.getCarCoord1().getY());
    }
}
