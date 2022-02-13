package com.example;

import java.util.ArrayList;

public class Player extends Sprite implements IPhysicsObject {
    // Width and height of the player
    public static final int WIDTH = 70;
    public static final int HEIGHT = 74;

    public final int GRAVITY = 2;

    private Boolean isFalling;
    private Vector2D momentum;

    /**
     * Create the player sprite and initialize some field variables
     * 
     * @param startPos The starting position of the player
     * @param assetName The name of the player image file including the file extension
     */
    Player(Vector2D startPos, String assetName) {
        super(startPos, new Vector2D(WIDTH, HEIGHT), assetName);

        // The player is always falling at the start of the game
        isFalling = true;

        // Initialize the momentum to an empty vector
        momentum = new Vector2D();
    }

    /**
     * Checks if the player is falling.
     * If the player is falling, increases the falling speed.
     * Updates the position, hitbox and image of the player
     */
    @Override
    public void move() {
        if (isFalling) {
            momentum.translate(0, GRAVITY);
        }

        // Move the player
        position.translate(momentum.getX(), momentum.getY());

        // Update both the hitbox and the image
        hitBox.setBounds(position.getX(), position.getY(), WIDTH, HEIGHT);
        image.setBounds(hitBox);
    }

    /**
     * Check if the player is already falling (jumping).
     * If not, give the player a boost upwards
     */
    public void jump() {
        if (!isFalling) {
            momentum.setY(-30);
        }

        isFalling = true;
    }

    /**
     * Check whether the player is colliding with any of the sprites in others
     * 
     * @param others An ArrayList containing all the sprites we want to check collision for
     */
    public void checkCollision(ArrayList<Sprite> others) {
        Boolean collision = false;

        // Loop through the ArrayList and check for a collision
        for (Sprite other : others) {
            if (isColliding(other)) {
                collision = true;
                isFalling = false;
                position.setY((int) other.getHitBox().getY() - HEIGHT + 1);
                momentum.setY(0);
            }
        }

        // The player is falling whenever it is not colliding with anything
        if (!collision) {
            isFalling = true;
        }
    }

    // Getters and setters

    public Vector2D getmomentum() {
        return momentum;
    }

    public Vector2D getPosition() {
        return position;
    }
}
