package com.example.tile;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.example.GamePanel;
import com.example.utility.FileLoader;
import com.example.utility.Vector2D;

public class Tile {
    private Vector2D position;

    private BufferedImage image;
    private Rectangle hitBox;

    /**
     * Create the tile sprite
     * 
     * @param position The position of this tile
     * @param assetName The name of the asset file including the file extension
     */
    public Tile(Vector2D position, Vector2D dimensions, String asset) {
        this.position = position;

        // Load the image
        image = new FileLoader().loadImage("assets/" + asset);

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(position.getX(), position.getY(), dimensions.getX(), dimensions.getY());
    }

    /**
     * Move the tile by x and y
     * 
     * @param x Change in x direction
     * @param y Change in y direction
     */
    public void move(int x, int y) {
        // Move the tile and update the hitbox
        position.translate(x, y);
        hitBox.translate(x, y);
    }

    /**
     * Draw the tile
     * 
     * @param graphics The graphics to draw the tile on
     */
    public void draw(Graphics2D graphics) {
        graphics.drawImage(image, position.getX(), position.getY(), GamePanel.tileSize, GamePanel.tileSize, null);
    }

    // Getters and setters
    public Rectangle getHitBox() {
        return hitBox;
    }
}