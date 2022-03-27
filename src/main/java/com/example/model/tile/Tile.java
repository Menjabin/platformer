package com.example.model.tile;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.example.utility.FileLoader;
import com.example.utility.Vector2D;
import com.example.view.View;

public class Tile {
    Vector2D position;
    Vector2D size;

    BufferedImage image;
    Rectangle hitBox;

    /**
     * Create the tile sprite
     * 
     * @param position The position of this tile
     * @param size The name of the asset file including the file extension
     */
    public Tile(Vector2D position, Vector2D size, String asset) {
        this.position = position;
        this.size = size;

        // Load the image
        image = new FileLoader().loadImage("assets/" + asset);

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(position.getX(), position.getY(), size.getX(), size.getY());
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
        graphics.drawImage(image, 
            View.translateToScale(position.getX()), 
            View.translateToScale(position.getY()), 
            View.translateToScale(size.getX()), 
            View.translateToScale(size.getY()), 
            null
        );
    }

    // Getters and setters
    public Rectangle getHitBox() {
        return hitBox;
    }
}