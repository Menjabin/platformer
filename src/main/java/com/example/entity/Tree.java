package com.example.entity;

import com.example.tile.Tile;
import com.example.utility.Vector2D;

public class Tree extends Tile {
    // The dimensions of this tile
    public static final int WIDTH = 330;
    public static final int HEIGHT = 348;

    /**
     * Create the tree sprite and change the hitbox to position it on the ground correctly
     * 
     * @param position The position of this tile
     * @param asset The name of the file including the file extension
     */
    public Tree(Vector2D position, String asset) {
        super(position, new Vector2D(WIDTH, HEIGHT), asset);
    }
}