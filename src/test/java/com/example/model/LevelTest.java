package com.example.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.example.model.tile.Tile;
import com.example.utility.Vector2D;

import org.junit.Test;

public class LevelTest {
    
    @Test
    public void testMovedCopy() {
        Level level = new Level();
        level.generateLevel();

        // Create a copy in the same place
        ArrayList<Tile> tilesCopy = level.movedCopy(new Vector2D(0, 0));

        assertTrue(level.getTiles().get(0).getPosition().equals(tilesCopy.get(0).getPosition()));

        tilesCopy = level.movedCopy(new Vector2D(10, 10));

        assertFalse(level.getTiles().get(0).getPosition().equals(tilesCopy.get(0).getPosition()));
    }

    @Test
    public void testIsCollidingWithPlayer() {

    }
}
