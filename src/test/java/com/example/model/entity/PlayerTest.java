package com.example.model.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import com.example.model.tile.Tile;

import org.junit.Test;

public class PlayerTest {

    //Player player = new Player(20, 20);
    
    @Test
    public void testIsCollidingWithTiles() {
        ArrayList<Tile> tiles = new ArrayList<Tile>();

        // Verify that the player is not colliding with anything
        //assertFalse(player.isCollidingWithTiles(player.getHitBox(), tiles));
        
        // Create a tile at the player's location
        tiles.add(new Tile(20, 20, 100, "grass.png"));

        //assertTrue(player.isCollidingWithTiles(player.getHitBox(), tiles));
    }

    @Test
    public void testMove() {
        /*
        player.move(10, 15);

        assertEquals(30, player.getPositionX());
        assertEquals(35, player.getPositionY());

        player.move(-5, -10);

        assertEquals(25, player.getPositionX());
        assertEquals(25, player.getPositionY());
        */
    }
}
