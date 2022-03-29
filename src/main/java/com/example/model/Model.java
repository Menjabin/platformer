package com.example.model;

import com.example.controller.Controllable;
import com.example.model.entity.Player;
import com.example.model.screen.GameScreen;
import com.example.model.tile.Tile;
import com.example.view.Viewable;

public class Model implements Viewable, Controllable {
    
    private Player player;
    private Level level;

    private int momentumX, momentumY;
    private GameScreen gameScreen;

    /**
     * The model is responsible for the game's logic
     */
    public Model() {
        // Create the player
        player = new Player(100, 100);

        // Generate the level
        level = new Level();
        level.generateLevel();
    }

    @Override
    public void tick() {
        player.tick(level.getTiles());

        level.move(-momentumX, -momentumY);
    }

    @Override
    public void move(int dx, int dy) {
        momentumX = dx * player.getSpeed();
        momentumY = dy * player.getSpeed();
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
}
