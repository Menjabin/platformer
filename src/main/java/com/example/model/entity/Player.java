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

    private int speed = 3;

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
        if (isFalling) {
            momentumY += GRAVITY;
        }

        // Check if moving the player results in a collision
        Rectangle movedHitBox = new Rectangle(
            positionX + momentumX,
            positionY + momentumY,
            WIDTH,
            HEIGHT
        );

        // Collision on the x axis
        if (momentumX < 0 && isCollidingWithTiles(movedHitBox, tiles, Direction.LEFT)) {
            momentumX = 0;
        }
        else if (momentumX > 0 && isCollidingWithTiles(movedHitBox, tiles, Direction.RIGHT)) {
            momentumX = 0;
        }

        // We are falling whenever we our feet are not colliding with anything
        if (momentumY >= 0 && isCollidingWithTiles(movedHitBox, tiles, Direction.DOWN)) {
            isFalling = false;
            momentumY = 0;
        }
        else {
            isFalling = true;
        }

        // Set the Y momentum to 0 if our head crashes into something
        if (momentumY < 0 && isCollidingWithTiles(movedHitBox, tiles, Direction.UP)) {
            momentumY = 0;
        }

        move(momentumX * speed, momentumY);
    }

    /**
     * Check if the player is already falling (jumping).
     * If not, give the player a boost upwards
     */
    public void jump() {
        if (!isFalling) {
            momentumY = -15;
        }

        isFalling = true;
    }

    /**
     * 
     * 
     * @param rect
     * @param direction
     * @return
     */
    public boolean isCollidingWithTiles(Rectangle rect, ArrayList<Tile> tiles, Direction direction) {
        for (Tile tile : tiles) {
            Rectangle hitBox = new Rectangle(
                tile.getPositionX(),
                tile.getPositionY(),
                tile.getSize(),
                tile.getSize()
            );

            if (hitBox != null) {
                if (rect.intersects(hitBox)) {
                    // Check if the collision happened in the desired direction
                    switch (direction) {
                        case UP:
                            Rectangle topRect = new Rectangle(
                                rect.x + (WIDTH / 8),
                                rect.y,
                                rect.width - (WIDTH / 4),
                                1
                            );

                            if (topRect.intersects(hitBox)) {
                                return true;
                            }
                            break;
                        case RIGHT:
                            Rectangle rightRect = new Rectangle(
                                rect.x + rect.width - 1,
                                rect.y + (HEIGHT / 8),
                                1,
                                rect.height - (HEIGHT / 4)
                            );

                            if (rightRect.intersects(hitBox)) {
                                return true;
                            }
                            break;
                        case DOWN:
                            Rectangle bottomRect = new Rectangle(
                                rect.x + (WIDTH / 8),
                                rect.y + rect.height - 1,
                                rect.width - (WIDTH / 8),
                                1
                            );

                            if (bottomRect.intersects(hitBox)) {
                                return true;
                            }
                            break;
                        case LEFT:
                            Rectangle leftRect = new Rectangle(
                                rect.x,
                                rect.y + (HEIGHT / 8),
                                1,
                                rect.height - (HEIGHT / 4)
                            );

                            if (leftRect.intersects(hitBox)) {
                                return true;
                            }
                            break;
                    }
                }
            }
        }

        return false;
    }

    // Getters and setters

    public int getSpeed() {
        return speed;
    }

    public void setMomentumX(int momentumX) {
        this.momentumX = momentumX;
    }

    public void setMomentumY(int momentumY) {
        this.momentumY = momentumY;
    }
}
