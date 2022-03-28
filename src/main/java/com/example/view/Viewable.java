package com.example.view;

import com.example.model.entity.Player;
import com.example.model.tile.Tile;

public interface Viewable {
    
    public Iterable<Tile> getTiles();

    public Player getPlayer();
}
