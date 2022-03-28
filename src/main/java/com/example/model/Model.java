package com.example.model;

import com.example.controller.Controllable;
import com.example.model.entity.Player;
import com.example.model.tile.Tile;
import com.example.utility.Vector2D;
import com.example.view.Viewable;

public class Model implements Viewable, Controllable {
    
    Player player;
    Level level;

    public Model() {
        // Create the player
        player = new Player(new Vector2D(10, 10), "player.png");

        // Generate the level
        level = new Level();
        level.generateLevel();
    }

    /**
     * Called every frame.
     * 
     * Updates the position of the camera and the player.
     * Checks for collisions between the player and the level tiles
     */
    public void update() {
        //player.update();

        player.checkCollision(level.getTiles());
    }

    /**
     * Check which keys are pressed, and move the camera accordingly.
     * The camera is not actually moved, we just move all the sprites other than the player
     */
    @Override
    public void move(Vector2D movement) {
        // Move all the sprites in the level
        for (Tile tile : level.getTiles()) {
            tile.move(movement.getX() * 10, 0);
        }

        update();
    }

    @Override
    public void jump() {
        player.jump();
    }

    @Override
    public Iterable<Tile> getTiles() {
        return level.getTiles();
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
