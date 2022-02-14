package com.example.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.example.utility.ImageLoader;
import com.example.utility.Vector2D;

public class Entity {
    protected Vector2D position;
    protected Vector2D dimensions;

    protected BufferedImage image;
    protected Rectangle hitBox;

    /**
     * Load the corresponding image and set the hitbox and swing boundaries
     * 
     * @param position The initial position of the sprite
     * @param dimensions The width and height of the sprite
     * @param assetName The filename of the asset including the file extension
     */
    public Entity(Vector2D position, Vector2D dimensions, String asset) {
        this.position = position;
        this.dimensions = dimensions;

        // Try loading the image
        image = new ImageLoader().loadImage(asset);

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(position.getX(), position.getY(), dimensions.getX(), dimensions.getY());
    }
    
    /**
     * Check for collision with another sprite 
     * 
     * @param other The other sprite
     * @return True if colliding, false if not
     */
    public Boolean isColliding(Entity other) {
        // Uses the function Rectangle.intersects() to check for collision
        if (hitBox.intersects(other.hitBox)) {
            return true;
        }

        return false;
    }

    /**
     * Move the sprite by x and y units
     * 
     * @param x Change in x direction
     * @param y Change in y direction
     */
    public void move(int x, int y) {
        // Translate both the hitbox and the position
        if (hitBox != null) {
            hitBox.translate(x, y);
        }
        position.translate(x, y);
    }

    // Getters and setters

    public Rectangle getHitBox() {
        return hitBox;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
