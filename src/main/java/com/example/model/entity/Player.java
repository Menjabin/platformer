package com.example.model.entity;

import java.util.ArrayList;

import com.example.model.tile.Tile;
import com.example.utility.Vector2D;
import com.example.view.View;

public class Player extends Entity {
    // Width and height of the player
    public static final int WIDTH = View.TILESIZE;
    public static final int HEIGHT = View.TILESIZE;

    public static final int GRAVITY = 2;

    Boolean isFalling;
    Vector2D momentum;

    /**
     * Create the player entity and initialize some field variables
     * 
     * @param position The starting position of the player
     * @param asset The name of the player image file including the file extension
     */
    public Player(Vector2D position) {
        super(position, new Vector2D(WIDTH, HEIGHT), "player.png");

        // The player is always falling at the start of the game
        isFalling = true;

        // Initialize the momentum to an empty vector
        momentum = new Vector2D();
    }

    /**
     * Update the player's size, momentum and position
     */
    public void update() {
        if (isFalling) {
            momentum.translate(0, GRAVITY);
        }

        move(momentum.getX(), momentum.getY());
    }

    /**
     * Check if the player is already falling (jumping).
     * If not, give the player a boost upwards
     */
    public void jump() {
        if (!isFalling) {
            momentum.setY(-20);
        }

        isFalling = true;
    }

    public Boolean isCollidingWithTiles(ArrayList<Tile> tiles) {
        for (Tile tile : tiles) {
            if (tile.getHitBox() != null) {
                if (this.hitBox.intersects(tile.getHitBox())) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Check whether the player is colliding with any of the tiles in others
     * 
     * @param others An ArrayList containing all the tiles we want to check collision for
     */
    public void checkCollision(ArrayList<Tile> others) {
        Boolean collision = false;

        // Loop through the ArrayList and check for a collision
        for (Tile other : others) {
            // Only check for objects that have a hitbox
            if (other.getHitBox() != null) {
                if (hitBox.intersects(other.getHitBox())) {
                    collision = true;
                    isFalling = false;
                    position.setY((int) other.getHitBox().getY() - HEIGHT + 1);
                    momentum.setY(0);
                }
            }
        }

        // The player is falling whenever it is not colliding with anything
        if (!collision) {
            isFalling = true;
        }
    }

    // Getters and setters

    public Vector2D getPosition() {
        return position;
    }
}
