package com.example.view;

import com.example.grid.Grid;
import com.example.model.entity.Player;
import com.example.model.screen.GameScreen;
import com.example.model.tile.Tile;

public interface Viewable {
    
    /**
     * @return an iterable containing all the tiles of the level
     */
    public Grid<Tile> getTiles();

    /**
     * @return the player object
     */
    public Player getPlayer();

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
