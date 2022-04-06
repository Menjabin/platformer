package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.grid.CoordinateItem;

import org.junit.Test;

public class LevelTest {

    // There exists a test level which consists of a 23 * 60 grid of grass tiles
    
    @Test
    public void testMove() {
        Level level = new Level("testLevel");

        int initialX = level.getTiles().get(0).getPositionX();
        int initialY = level.getTiles().get(0).getPositionY();

        level.move(50, 40);

        assertEquals(initialX + 50, level.getTiles().get(0).getPositionX());
        assertEquals(initialY + 40, level.getTiles().get(0).getPositionY());
    }

    @Test
    public void testLoadingLevel() {
        Level level = new Level("testLevel");

        // All tiles should be grass tiles (tile number 1)
        for (CoordinateItem<Integer> tile : level.getTileMap()) {
            assertEquals(1, tile.item);
        }

        // Check the dimensions of the tile map
        assertEquals(23, level.getTileMap().getRows());
        assertEquals(60, level.getTileMap().getCols());
    }
}
