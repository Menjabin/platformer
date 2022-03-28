package com.example.model;

import com.example.controller.Controllable;
import com.example.model.entity.Player;
import com.example.model.screen.GameScreen;
import com.example.model.tile.Tile;
import com.example.utility.Vector2D;
import com.example.view.Viewable;

public class Model implements Viewable, Controllable {
    
    Player player;
    Level level;

    Vector2D momentum = new Vector2D();
    GameScreen gameScreen;

    /**
     * The model is responsible for the game's logic
     */
    public Model() {
        // Create the player
        player = new Player(new Vector2D(10, 10));

        // Generate the level
        level = new Level();
        level.generateLevel();
    }

    @Override
    public void update() {
        //player.update();

        player.checkCollision(level.getTiles());
        level.move(new Vector2D(-momentum.getX(), -momentum.getY()));
    }

    @Override
    public void move(int dx, int dy) {
        momentum = new Vector2D(dx * 10, dy * 10);
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
