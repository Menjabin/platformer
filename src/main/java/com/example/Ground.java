package com.example;

public class Ground extends Sprite {
    // The dimensions of this ground tile
    public static final int WIDTH = 400;
    public static final int HEIGHT = 68;

    // There are some flowers on the ground which we do not want to collide with
    private int offsetY = 25;

    /**
     * Create the ground sprite and change the hitbox to avoid collision with the flowers
     * 
     * @param position The position of this ground tile
     * @param assetName The name of the file including the file extension
     */
    Ground(Vector2D position, String assetName) {
        super(position, new Vector2D(WIDTH, HEIGHT), assetName);

        // Fix flower collision
        hitBox.translate(0, offsetY);
        hitBox.setSize(WIDTH, HEIGHT - offsetY);
    }
}