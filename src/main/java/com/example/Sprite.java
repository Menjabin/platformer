package com.example;

import java.io.File;
import java.io.IOException;

import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite {
    protected Vector2D position;

    protected JLabel image;
    protected Rectangle hitBox;

    Sprite(Vector2D position, int width, int height, String assetName) {
        // Load the image
        try {
            image = new JLabel(new ImageIcon(ImageIO.read(new File(getClass().getResource(assetName).getPath()))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(position.getX(), position.getY(), width, height);
        image.setBounds(hitBox);

        this.position = position;
    }
    
    public Boolean isColliding(Sprite other) {
        if (hitBox.intersects(other.hitBox)) {
            return true;
        }

        return false;
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

    public JLabel getImage() {
        return image;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }
}
