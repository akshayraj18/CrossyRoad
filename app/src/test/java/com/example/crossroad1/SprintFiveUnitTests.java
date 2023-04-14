package com.example.crossroad1;

import org.junit.Test;
import static org.junit.Assert.*;
import com.example.crossroad1.enums.Difficulty;
import com.example.crossroad1.enums.Sprite;


public class SprintFiveUnitTests {
    private Grid grid = new Grid();
    private Player goat = new Player("Harsha", Sprite.MJ, Difficulty.EASY);
    private Runnable carMove = new Runnable() {
        @Override
        public void run() {
            if ((grid.hasCollision() || grid.inWater()) && grid.getPlayerCoord().getY() != 11) {
                grid = new Grid();
                goat.decLives();
                Player.setPoints(0);
            }
        }
    };
    private Runnable ufoMove = new Runnable() {
        @Override
        public void run() {
            if ((grid.hasCollision() || grid.inWater()) && grid.getPlayerCoord().getY() != 11) {
                grid = new Grid();
                goat.decLives();
                Player.setPoints(0);
            }
        }
    };
    private Runnable jetMove = new Runnable() {
        @Override
        public void run() {
            if ((grid.hasCollision() || grid.inWater()) && grid.getPlayerCoord().getY() != 11) {
                grid = new Grid();
                goat.decLives();
                Player.setPoints(0);
            }
        }
    };

    @Test
    public void checkReachedGoal() {
        Player.setPoints(0);
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertTrue(grid.reachedGoal());
    }

    @Test
    public void checkReachedGoal2() {
        Player.setPoints(0);
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveDown();
        grid.moveLeft();
        grid.moveUp();
        grid.moveRight();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertTrue(grid.reachedGoal());
    }

    @Test
    public void checkReachedGoal3() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveDown();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertTrue(grid.reachedGoal());
    }

    @Test
    public void checkOnLog() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertFalse(grid.inWater());
    }

    @Test
    public void checkOnLog2() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveRight();
        grid.moveLeft();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertFalse(grid.inWater());
    }

    @Test
    public void checkOnLog3() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertFalse(grid.inWater());
    }


    @Test
    public void checkGoalPoints1() {
        Player.setPoints(0);
        grid.resetPlayer();
        Grid.resetYMax();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveDown();
        grid.moveUp();
        grid.moveUp();
        assertEquals(6300, Player.getPoints());
    }

    @Test
    public void checkGoalPoints2() {
        Player.setPoints(0);
        grid.resetPlayer();
        Grid.resetYMax();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveRight();
        grid.moveLeft();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertEquals(6300, Player.getPoints());
    }

    @Test
    public void checkGoalPoints3() {
        Player.setPoints(0);
        grid.resetPlayer();
        Grid.resetYMax();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveRight();
        grid.moveUp();
        grid.moveDown();
        grid.moveLeft();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertEquals(6300, Player.getPoints());
    }

    @Test
    public void missLog1() {
        Player.setLives(1);
        Player.setPoints(0);
        grid.resetPlayer();
        Grid.resetYMax();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveLeft();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertTrue(grid.inWater());
    }

    @Test
    public void fallOffLog1() {
        Player.setLives(1);
        Player.setPoints(0);
        grid.resetPlayer();
        Grid.resetYMax();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveLeft();
        assertTrue(grid.inWater());
    }

    @Test
    public void fallOffLog2() {
        Player.setLives(1);
        Player.setPoints(0);
        grid.resetPlayer();
        Grid.resetYMax();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveRight();
        assertTrue(grid.inWater());
    }
}
