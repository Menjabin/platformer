package com.example.sprites;

import com.example.utility.Vector2D;

public class Tile extends Sprite {
    /**
     * Create the tile sprite
     * 
     * @param position The position of this tile
     * @param assetName The name of the asset file including the file extension
     */
    public Tile(Vector2D position, Vector2D dimensions, String assetName) {
        super(position, dimensions, assetName);
    }
}