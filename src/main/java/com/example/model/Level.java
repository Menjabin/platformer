package com.example.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.model.tile.Tile;
import com.example.utility.FileLoader;
import com.example.view.View;

public class Level {
    // Two dimensional array list for storing the level layout
    // The first dimension is y-coordinates, and the second dimension is x-coordinates
    ArrayList<String[]> layout = new ArrayList<String[]>();

    // Contains all the sprites belonging to this level
    ArrayList<Tile> tiles = new ArrayList<Tile>();

    /**
     * Read the level file and store the data in the layout array
     */
    public Level() {
        File file = new FileLoader().readFile("levels/level1.tmx");

        try {
            Scanner sc = new Scanner(file);

            // Skip XML lines
            for (int i = 0; i < 5; i++) {
                sc.nextLine();
            }

            for (int i = 0; i < View.MAXSCREENROW; i++) {
                layout.add(sc.nextLine().split(","));
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate all the tiles which will populate the level.
     * Loops through the two dimensional array "layout", and generates the appropriate tiles
     */
    public void generateLevel() {
        int tileSize = View.TILESIZE;

        for (int y = 0; y < layout.size(); y++) {
            String[] row = layout.get(y);
            for (int x = 0; x < row.length; x++) {
                // Add the corresponding tiles to the grid
                if (row[x].equals("1")) {
                    tiles.add(new Tile(x * tileSize, y * tileSize, tileSize, "grass.png"));
                }
                if (row[x].equals("2")) {
                    System.out.println("test");
                }
            }
        }
    }

    /**
     * Returns a copy of this level where all tiles are moved
     * 
     * @param movement movement in x and y direction
     * @return a copy of this level
     */
    public ArrayList<Tile> movedCopy(int dx, int dy) {
        ArrayList<Tile> tilesCopy = new ArrayList<Tile>();

        for (Tile tile : tiles) {
            tilesCopy.add(new Tile(
                tile.getPositionX() + dx, 
                tile.getPositionY() + dy,
                tile.getSize(), 
                tile.getAsset()
            ));
        }

        return tilesCopy;
    }

    /**
     * Move the level
     * 
     * @param dx change in x direction
     * @param dy change in y direction
     */
    public void move(int dx, int dy) {
        for (Tile tile : tiles) {
            tile.move(dx, dy);
        }
    }

    // Getters and setters

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}