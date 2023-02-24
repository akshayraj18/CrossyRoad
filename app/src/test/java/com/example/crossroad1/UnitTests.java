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
        assertEquals(5,grid.getPlayerCoord().getX());
    }
}
