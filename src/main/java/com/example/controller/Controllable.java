package com.example.controller;

import com.example.model.screen.GameScreen;

public interface Controllable {

    /**
     * Check which keys are pressed, and move the camera accordingly.
     * The camera is not actually moved, we just move all the sprites other than the player
     * 
     * @param dx change in x direction
     * @param dy change in y direction
     */
    public void move(int dx, int dy);

    /**
     * Makes the player jump
     */
    public void jump();

    /**
     * Called every frame.
     * 
     * Updates the position of the camera and the player.
     * Checks for collisions between the player and the level tiles
     */
    public void tick();

    /**
     * Set the game screen to a given value
     * 
     * @param gameScreen the new game screen
     */
    public void setGameScreen(GameScreen gameScreen);

    /**
     * @return the current game screen
     */
    public GameScreen getGameScreen();
}
