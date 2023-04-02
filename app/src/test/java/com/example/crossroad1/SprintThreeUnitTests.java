package com.example.crossroad1;

import org.junit.Test;
import static org.junit.Assert.*;


public class SprintThreeUnitTests {
    private Grid grid = new Grid();

    @Test
    public void scoreIncreasesUpwards3() {
        grid.moveUp();
        grid.moveUp();
        grid.moveDown();
        grid.moveRight();
        grid.moveUp();
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
    public void noScoreIncrease() {
        grid.moveUp();
        grid.moveDown();
        grid.moveUp();
        grid.moveRight();
        assertEquals(300, Player.getPoints());
    }

    @Test
    public void checkCarRow() {
        assertEquals(10, grid.getCarCoord1().getY());
    }

    @Test
    public void checkUFORow() {
        assertEquals(9, grid.getUfoCoord1().getY());
        assertEquals(7, grid.getUfoCoord2().getY());
    }

    @Test
    public void checkJetRow() {
        assertEquals(8, grid.getJetCoord1().getY());
        assertEquals(6, grid.getJetCoord2().getY());
    }

    @Test
    public void checkJet1Spawn() {
        assertEquals(7, grid.getJetCoord1().getX());
    }

    @Test
    public void checkJet2Spawn() {
        assertEquals(7, grid.getJetCoord2().getX());
    }
    @Test
    public void checkUFOSpawn() {
        assertEquals(0, grid.getUfoCoord1().getX());
        assertEquals(0,  grid.getUfoCoord2().getX());
    }

    @Test
    public void handlesBoundaryScoreIncrease() {
        grid.moveDown();
        grid.moveUp();
        grid.moveUp();
        assertEquals(300, Player.getPoints());
    }

    @Test
    public void checkCarSpawn() {
        assertEquals(7, grid.getCarCoord1().getX());

    }

    @Test
    public void noScoreIncrease2() {
        grid.moveUp();
        grid.moveUp();
        grid.moveDown();
        grid.moveUp();
        assertEquals(300, Player.getPoints());
    }
}