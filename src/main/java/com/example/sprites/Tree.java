package com.example.sprites;

import com.example.utility.Vector2D;

public class Tree extends Sprite {
    // The dimensions of this ground tile
    public static final int WIDTH = 330;
    public static final int HEIGHT = 348;

    /**
     * Create the tree sprite and change the hitbox to position it on the ground correctly
     * 
     * @param position The position of this ground tile
     * @param assetName The name of the file including the file extension
     */
    public Tree(Vector2D position, String assetName) {
        super(position, new Vector2D(WIDTH, HEIGHT), assetName);

        hitBox = null;
    }
}