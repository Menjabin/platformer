package com.example.model;

import java.awt.Rectangle;

import com.example.controller.Controllable;
import com.example.model.entity.Direction;
import com.example.model.entity.Player;
import com.example.model.screen.GameScreen;
import com.example.model.tile.Tile;
import com.example.view.Viewable;

public class Model implements Viewable, Controllable {
    
    private Player player;
    private Level level;

    private int momentumX, momentumY;
    private GameScreen gameScreen;

    public boolean keyLeft, keyRight;

    /**
     * The model is responsible for the game's logic
     */
    public Model() {
        // Create the player
        player = new Player(200, 100);

        // Generate the level
        level = new Level();
        level.generateLevel();
    }

    @Override
    public void tick() {
        if (keyLeft && keyRight) {
            momentumX = 0;
        }
        else if (keyLeft) {
            momentumX = -1 * player.getSpeed();
        }
        else if (keyRight) {
            momentumX = 1 * player.getSpeed();
        }
        else {
            momentumX = 0;
        }

        Rectangle movedHitBox = new Rectangle(
            player.getPositionX() + momentumX,
            player.getPositionY() + momentumY,
            Player.WIDTH,
            Player.HEIGHT
        );

        if (!level.isCollidingWithRect(movedHitBox, Direction.RIGHT) && !level.isCollidingWithRect(movedHitBox, Direction.LEFT)) {
            level.move(-momentumX, -momentumY);
        }
        
        player.tick(level.getTiles());
    }

    @Override
    public void restart() {
        player.setPosition(200, 100);
        player.setMomentum(0, 0);
    }

    @Override
    public void jump() {
        player.jump();
    }

    // Getters and setters

    @Override
    public Iterable<Tile> getTiles() {
        return this.level.getTiles();
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public GameScreen getGameScreen() {
        return this.gameScreen;
    }

    @Override
    public void setKeyLeft(boolean keyLeft) {
        this.keyLeft = keyLeft;
    }

    @Override
    public void setKeyRight(boolean keyRight) {
        this.keyRight = keyRight;
    }

    @Override
    public boolean getKeyLeft() {
        return this.keyLeft;
    }

    @Override
    public boolean setKeyLeft() {
        return this.keyRight;
    }
}
