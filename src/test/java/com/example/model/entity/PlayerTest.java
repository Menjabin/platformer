package com.example.model.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import com.example.model.tile.Tile;
import com.example.utility.Vector2D;

import org.junit.Test;

public class PlayerTest {

    Player player = new Player(new Vector2D(20, 20));
    
    @Test
    public void testIsCollidingWithTiles() {
        ArrayList<Tile> tiles = new ArrayList<Tile>();

        // Verify that the player is not colliding with anything
        assertFalse(player.isCollidingWithTiles(tiles));
        
        // Create a tile at the player's location
        tiles.add(new Tile(new Vector2D(20, 20), new Vector2D(100, 100), "grass.png"));

        assertTrue(player.isCollidingWithTiles(tiles));
    }
}
