package com.example;

import java.io.File;
import java.io.IOException;

import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite {
    protected Vector2D position;
    protected Vector2D momentum;

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
        Rectangle rect = new Rectangle(position.getX(), position.getY(), width, height);
        image.setBounds(rect);
        hitBox.setBounds(rect);
    }

    // Getters and setters

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public Vector2D getMomentum() {
        return momentum;
    }

    public void setMomentum(Vector2D momentum) {
        this.momentum = momentum;
    }

    public JLabel getImage() {
        return image;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }
}
