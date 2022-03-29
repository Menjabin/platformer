package com.example.model.tile;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.example.utility.FileLoader;

public class Tile {
    private int positionX, positionY;
    private int size;
    private String asset;

    private BufferedImage image;
    private Rectangle hitBox;

    /**
     * Create the tile sprite
     * 
     * @param position The position of this tile
     * @param size The name of the asset file including the file extension
     */
    public Tile(int positionX, int positionY, int size, String asset) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
        this.asset = asset;

        // Load the image
        image = new FileLoader().loadImage("assets/" + asset);

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(positionX, positionY, size, size);
    }

    /**
     * Move the tile by dx and dy
     * 
     * @param dx Change in x direction
     * @param dy Change in y direction
     */
    public void move(int dx, int dy) {
        // Move the tile and update the hitbox
        positionX += dx;
        positionY += dy;
        hitBox.translate(dx, dy);
    }

    // Getters and setters

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public int getSize() {
        return this.size;
    }

    public String getAsset() {
        return this.asset;
    }

    public Rectangle getHitBox() {
        return this.hitBox;
    }

    public BufferedImage getImage() {
        return this.image;
    }
}