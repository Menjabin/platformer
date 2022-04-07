package com.example.model.entity;

import java.awt.Rectangle;

import com.example.grid.CoordinateItem;
import com.example.grid.Grid;
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
     * Update the player's momentum and position
     */
    public void tick(Grid<Tile> tiles) {
        if (isFalling) {
            momentumY += GRAVITY;
        }

        Rectangle movedHitBox = new Rectangle(
            positionX + (momentumX * speed),
            positionY + (momentumY),
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

        if (isFalling) {
            if (isCollidingWithTiles(movedHitBox, tiles, Direction.DOWN)) {
                isFalling = false;
                momentumY = 0;
            }
            else {

            }
        }
        else {
            Rectangle newHitBox = new Rectangle(
                positionX + (momentumX * speed),
                positionY + 1,
                WIDTH,
                HEIGHT
            );

            if (!isCollidingWithTiles(newHitBox, tiles, Direction.DOWN)) {
                isFalling = true;
            }
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
     * Take in a rectangle and a grid of tiles, and check if the rectangle collides with any
     * tiles in a given direction
     * 
     * @param rect the rectangle to test collision for
     * @param tiles the tiles to collide with
     * @param direction the direction of collision
     * @return true if colliding, false if not
     */
    public boolean isCollidingWithTiles(Rectangle rect, Grid<Tile> tiles, Direction direction) {
        for (CoordinateItem<Tile> tileItem : tiles) {
            Tile tile = tileItem.item;

            if (tile != null) {
                Rectangle hitBox = new Rectangle(
                    tile.getPositionX(),
                    tile.getPositionY(),
                    tile.getSize(),
                    tile.getSize()
                );

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
