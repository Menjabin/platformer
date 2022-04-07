package com.example.model;

import com.example.controller.Controllable;
import com.example.grid.Grid;
import com.example.model.entity.Player;
import com.example.model.screen.GameScreen;
import com.example.model.tile.Tile;
import com.example.view.Viewable;

public class Model implements Viewable, Controllable {
    
    private Player player;
    private Level level;

    private int momentumX;
    private GameScreen gameScreen;

    public boolean keyLeft, keyRight;

    /**
     * The model is responsible for the game's logic
     */
    public Model() {
        // Generate the level
        level = new Level("level1");

        // Create the player
        player = new Player(200, 100);
    }

    /**
     * Creates a model with a given player and level
     * 
     * @param player pre-made player
     * @param level pre-made level
     */
    public Model(Player player, Level level) {
        this.player = player;
        this.level = level;
    }

    @Override
    public void tick() {
        if (keyLeft && keyRight) {
            momentumX = 0;
        }
        else if (keyLeft) {
            momentumX = -1;
        }
        else if (keyRight) {
            momentumX = 1;
        }
        else {
            momentumX = 0;
        }
        
        player.setMomentumX(momentumX);
        player.tick(level.getTiles());
    }

    @Override
    public void restart() {
        player.setPosition(200, 100);
        player.setMomentumX(0);
        player.setMomentumY(0);
    }

    @Override
    public void jump() {
        player.jump();
    }

    // Getters and setters

    @Override
    public Grid<Tile> getTiles() {
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
