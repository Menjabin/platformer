package com.example.sprites;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.example.utility.Vector2D;

import org.xml.sax.InputSource;

public class Sprite {
    protected Vector2D position;
    protected Vector2D dimensions;

    protected JLabel image;
    protected Rectangle hitBox;

    /**
     * Load the corresponding image and set the hitbox and swing boundaries
     * 
     * @param position The initial position of the sprite
     * @param dimensions The width and height of the sprite
     * @param assetName The filename of the asset including the file extension
     */
    public Sprite(Vector2D position, Vector2D dimensions, String assetName) {
        this.position = position;
        this.dimensions = dimensions;

        // Try loading the image
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("assets/" + assetName);

            image = new JLabel(new ImageIcon(ImageIO.read(inputStream)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Configure the hitbox and the swing boundaries
        hitBox = new Rectangle(position.getX(), position.getY(), dimensions.getX(), dimensions.getY());
        image.setBounds(hitBox);
    }
    
    /**
     * Check for collision with another sprite 
     * 
     * @param other The other sprite
     * @return True if colliding, false if not
     */
    public Boolean isColliding(Sprite other) {
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
        hitBox.translate(x, y);
        position.translate(x, y);
        // We cannot just pass the hitbox as an argument here, because some sprites have different bounds and hitboxes
        image.setBounds(position.getX(), position.getY(), dimensions.getX(), dimensions.getY());
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
