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
}
