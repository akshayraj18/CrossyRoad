package com.example.crossroad1;

import org.junit.Test;
import static org.junit.Assert.*;
import com.example.crossroad1.enums.Difficulty;
import com.example.crossroad1.enums.Sprite;


public class SprintFourUnitTests {
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
    public void checkWaterCollision() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        assertEquals(true, grid.inWater());
    }

    @Test
    public void checkCarCollision() {
        grid.moveUp();
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        assertEquals(true, grid.hasCollision());
    }

    @Test
    public void checkUFOCollision() {
        grid.moveUp();
        grid.moveUp();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        assertEquals(true, grid.hasCollision());
    }

    @Test
    public void checkJetCollision() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        assertEquals(true, grid.hasCollision());
    }

    @Test
    public void checkCarResetPoints() {
        grid.moveUp();
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        carMove.run();
        assertEquals(0, Player.getPoints());
    }

    @Test
    public void checkJetResetPoints() {
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        jetMove.run();
        assertEquals(0, Player.getPoints());
    }

    @Test
    public void checkUFOResetPoints() {
        grid.moveUp();
        grid.moveUp();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        ufoMove.run();
        assertEquals(0, Player.getPoints());
    }

    @Test
    public void checkUFODecreaselife() {
        Player.setLives(1);
        grid.moveUp();
        grid.moveUp();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        ufoMove.run();
        assertEquals(0, Player.getLives());
    }

    @Test
    public void checkJetDecreaseLife() {
        Player.setLives(1);
        grid.moveUp();
        grid.moveUp();
        grid.moveUp();
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        jetMove.run();
        assertEquals(0, Player.getLives());
    }

    @Test
    public void checkCarDecreaseLife() {
        Player.setLives(1);
        grid.moveUp();
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        carMove.run();
        assertEquals(0, Player.getLives());
    }

    @Test
    public void checkCarCollisionRespawn() {
        grid.moveUp();
        grid.moveRight();
        grid.moveRight();
        grid.moveRight();
        carMove.run();
        assertEquals(7, grid.getCarCoord1().getX());
        assertEquals(10, grid.getCarCoord1().getY());

    }


    @Test
    public void checkUFOCollisionRespawn() {
        grid.moveUp();
        grid.moveUp();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        grid.moveLeft();
        ufoMove.run();
        assertEquals(7, grid.getCarCoord1().getX());
        assertEquals(10, grid.getCarCoord1().getY());
    }
}