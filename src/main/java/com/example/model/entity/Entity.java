package com.example.model.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.example.utility.FileLoader;

public class Entity {

    protected BufferedImage image;
    protected Rectangle hitBox;

    protected int positionX, positionY;
    protected int sizeX, sizeY;

    /**
     * Load the corresponding image and update the hitbox
     * 
     * @param position The initial position of the sprite
     * @param size The width and height of the sprite
     * @param asset The filename of the asset including the file extension
     */
    public Entity(int positionX, int positionY, int sizeX, int sizeY, String asset) {
        this.positionX = positionX;
        this.positionY = positionY;

        this.sizeX = sizeX;
        this.sizeY = sizeY;

        // Try loading the image
        image = new FileLoader().loadImage("assets/" + asset);

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(positionX, positionY, sizeX, sizeY);
    }

    /**
     * Move the entity by x and y units
     * 
     * @param dx Change in x direction
     * @param dy Change in y direction
     */
    public void move(int dx, int dy) {
        // Translate both the hitbox and the position
        positionX += dx;
        positionY += dy;
        hitBox.translate(dx, dy);
    }

    // Getters and setters

    public Rectangle getHitBox() {
        return hitBox;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setPosition(int positionX, int positionY) {
        this.hitBox.x = positionX;
        this.hitBox.y = positionY;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
