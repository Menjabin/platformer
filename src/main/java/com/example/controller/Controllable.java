package com.example.controller;

import com.example.model.screen.GameScreen;

public interface Controllable {

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
     * Move the player back to its starting position
     */
    public void restart();

    /**
     * Set the keyLeft variable
     * 
     * @param keyLeft true if the key is down, false otherwise
     */
    public void setKeyLeft(boolean keyLeft);

    /**
     * Set the keyRight variable
     * 
     * @param keyRight true if the key is down, false otherwise
     */
    public void setKeyRight(boolean keyRight);

    /**
     * @return true if the left key is down, false otherwise
     */
    public boolean getKeyLeft();

    /**
     * @return true if the left key is down, false otherwise
     */
    public boolean setKeyLeft();

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
