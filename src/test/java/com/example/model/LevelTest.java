package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LevelTest {
    
    @Test
    public void testMove() {
        Level level = new Level();
        level.generateLevel();

        int initialX = level.getTiles().get(0).getPositionX();
        int initialY = level.getTiles().get(0).getPositionY();

        level.move(50, 40);

        assertEquals(initialX + 50, level.getTiles().get(0).getPositionX());
        assertEquals(initialY + 40, level.getTiles().get(0).getPositionY());
    }

    @Test
    public void testIsCollidingWithPlayer() {

    }
}
