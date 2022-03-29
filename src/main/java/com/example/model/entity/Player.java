package com.example.model.entity;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.example.model.tile.Tile;
import com.example.view.View;

public class Player extends Entity {
    // Width and height of the player
    public static final int WIDTH = View.TILESIZE;
    public static final int HEIGHT = View.TILESIZE * 2;

    public static final int GRAVITY = 1;

    private int speed = 10;

    Boolean isFalling;
    private int momentumX, momentumY;

    /**
     * Create the player entity and initialize some field variables
     * 
     * @param position The starting position of the player
     * @param asset The name of the player image file including the file extension
     */
    public Player(int positionX, int positionY) {
        super(positionX, positionY, WIDTH, HEIGHT, "player.png");

        // The player is always falling at the start of the game
        isFalling = true;

        momentumX = momentumY = 0;
    }

    /**
     * Update the player's size, momentum and position
     */
    public void tick(ArrayList<Tile> tiles) {
        // Check if moving the player results in a collision
        Rectangle movedHitBox = new Rectangle(
            hitBox.x + momentumX,
            hitBox.y + momentumY,
            hitBox.width + momentumX,
            hitBox.height + momentumY
        );

        if (isCollidingWithTiles(movedHitBox, tiles)) {
            isFalling = false;
            momentumY = 0;
            return;
        }
        else {
            isFalling = true;
        }

        if (isFalling) {
            momentumY += GRAVITY;
        }

        move(momentumX, momentumY);
    }

    /**
     * Check if the player is already falling (jumping).
     * If not, give the player a boost upwards
     */
    public void jump() {
        if (!isFalling) {
            momentumY = -20;
        }

        isFalling = true;
    }

    public boolean isCollidingWithTiles(Rectangle rect, ArrayList<Tile> tiles) {
        for (Tile tile : tiles) {
            if (tile.getHitBox() != null) {
                if (rect.intersects(tile.getHitBox())) {
                    return true;
                }
            }
        }

        return false;
    }

    // Getters and setters

    public int getSpeed() {
        return speed;
    }

    public void setMomentum(int momentumX, int momentumY) {
        this.momentumX = momentumX;
        this.momentumY = momentumY;
    }
}
