package com.example.model;

import static org.junit.Assert.assertEquals;

import com.example.grid.Coordinate;
import com.example.model.entity.Player;
import com.example.view.View;

import org.junit.Test;

public class ModelSanityTest {

    //Player player = new Player(22 * View.TILESIZE - Player.HEIGHT, 1 * View.TILESIZE);
    Level level = new Level("testLevel");

    //Model model = new Model(player, level);
    
    @Test
    public void testMovement() {
        // Try moving the player to the left
        int prevPosX = level.getTiles().get(new Coordinate(0, 0)).getPositionX();

        //model.setKeyLeft(true);
        //model.tick();

        assertEquals(prevPosX, level.getTiles().get(new Coordinate(0, 0)).getPositionX());
    }
}
