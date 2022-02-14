package com.example.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.example.utility.FileLoader;
import com.example.utility.Vector2D;

public class Entity {
    protected Vector2D position;
    protected Vector2D dimensions;

    protected BufferedImage image;
    protected Rectangle hitBox;

    /**
     * Load the corresponding image and update the hitbox
     * 
     * @param position The initial position of the sprite
     * @param dimensions The width and height of the sprite
     * @param asset The filename of the asset including the file extension
     */
    public Entity(Vector2D position, Vector2D dimensions, String asset) {
        this.position = position;
        this.dimensions = dimensions;

        // Try loading the image
        image = new FileLoader().loadImage("assets/" + asset);

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(position.getX(), position.getY(), dimensions.getX(), dimensions.getY());
    }

    /**
     * Move the entity by x and y units
     * 
     * @param x Change in x direction
     * @param y Change in y direction
     */
    public void move(int x, int y) {
        // Translate both the hitbox and the position
        hitBox.translate(x, y);
        position.translate(x, y);
    }

    // Getters and setters

    public Rectangle getHitBox() {
        return hitBox;
    }

    public Vector2D getPosition() {
        return position;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
