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
        assertEquals(10, Grid.getCarCoord1().getY());
    }

    @Test
    public void checkUFORow() {
        assertEquals(9, Grid.getUfoCoord1().getY());
        assertEquals(7, Grid.getUfoCoord2().getY());
    }

    @Test
    public void checkJetRow() {
        assertEquals(8, Grid.getJetCoord1().getY());
        assertEquals(6, Grid.getJetCoord2().getY());
    }

    @Test
    public void checkJet1Spawn() {
        assertEquals(7, Grid.getJetCoord1().getX());
    }

    @Test
    public void checkJet2Spawn() {
        assertEquals(7, Grid.getJetCoord2().getX());
    }
    @Test
    public void checkUFOSpawn() {
        assertEquals(0, Grid.getUfoCoord1().getX());
        assertEquals(0,  Grid.getUfoCoord2().getX());
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
        assertEquals(7, Grid.getCarCoord1().getX());

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