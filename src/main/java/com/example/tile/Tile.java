package com.example.tile;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.example.GamePanel;
import com.example.utility.ImageLoader;
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

        // Try loading the image
        image = new ImageLoader().loadImage(asset);

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(position.getX(), position.getY(), dimensions.getX(), dimensions.getY());
    }

    public void move(int x, int y) {
        // Move the tile
        position.translate(x, y);

        // Update the hitbox
        hitBox.setBounds(position.getX(), position.getY(), GamePanel.TILESIZE, GamePanel.TILESIZE);
    }

    public void draw(Graphics2D graphics) {
        graphics.drawImage(image, position.getX(), position.getY(), GamePanel.TILESIZE, GamePanel.TILESIZE, null);
    }

    // Getters and setters
    public Rectangle getHitBox() {
        return hitBox;
    }
}