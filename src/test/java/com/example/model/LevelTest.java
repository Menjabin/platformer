package com.example.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.example.model.tile.Tile;

import org.junit.Test;

public class LevelTest {
    
    @Test
    public void testMovedCopy() {
        Level level = new Level();
        level.generateLevel();

        // Create a copy in the same place
        ArrayList<Tile> tilesCopy = level.movedCopy(0, 0);

        assertTrue(level.getTiles().get(0).getPositionX() == tilesCopy.get(0).getPositionX());
        assertTrue(level.getTiles().get(0).getPositionY() == tilesCopy.get(0).getPositionY());

        tilesCopy = level.movedCopy(10, 10);

        assertFalse(level.getTiles().get(0).getPositionX() == tilesCopy.get(0).getPositionX());
        assertFalse(level.getTiles().get(0).getPositionY() == tilesCopy.get(0).getPositionY());
    }

    @Test
    public void testIsCollidingWithPlayer() {

    }
}
