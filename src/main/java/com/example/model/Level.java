package com.example.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.grid.Coordinate;
import com.example.grid.CoordinateItem;
import com.example.grid.Grid;
import com.example.model.tile.Tile;
import com.example.utility.FileLoader;
import com.example.view.View;

public class Level {
    // Contains all the tiles belonging to this level, including empty ones
    private Grid<Tile> tiles;

    // A grid representing the level
    private Grid<Integer> tileMap;

    /**
     * Read the level file and store the data in the layout array
     * 
     * @param levelName the name of the current level file
     */
    public Level(String levelName) {
        File file = new FileLoader().readFile("levels/" + levelName + ".tmx");

        try {
            Scanner sc = new Scanner(file);

            // Skip XML lines
            for (int i = 0; i < 5; i++) {
                sc.nextLine();
            }

            // Read the file
            ArrayList<String[]> lines = new ArrayList<String[]>();

            while (sc.hasNext()) {
                String nextLine = sc.nextLine();
                if (nextLine.startsWith("0") || nextLine.startsWith("1")) {
                    lines.add(nextLine.split(","));
                }
            }

            sc.close();

            // Populate the grid with numbers corresponding to tiles
            tileMap = new Grid<Integer>(lines.size(), lines.get(0).length);

            for (int i = 0; i < tileMap.getRows(); i++) {
                for (int j = 0; j < tileMap.getCols(); j++) {
                    tileMap.set(new Coordinate(i, j), Integer.parseInt(lines.get(i)[j]));
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        generateLevel();
    }

    /**
     * Generates all the tiles which will populate the level.
     * Loops through the grid and generates the appropriate tiles
     */
    private void generateLevel() {
        int tileSize = View.TILESIZE;
        tiles = new Grid<Tile>(tileMap.getRows(), tileMap.getCols());

        for (int x = 0; x < tileMap.getCols(); x++) {
            for (int y = 0; y < tileMap.getRows(); y++) {
                int tileType = tileMap.get(new Coordinate(y, x));
                Tile tile = null;

                // Add the corresponding tiles to the grid
                if (tileType == 1) {
                    tile = new Tile(x * tileSize, y * tileSize, tileSize, "grass.png");
                }
                if (tileType == 2) {
                    System.out.println("test");
                }

                tiles.set(new Coordinate(y, x), tile);
            }
        }
    }

    /**
     * Move the level
     * 
     * @param dx change in x direction
     * @param dy change in y direction
     */
    public void move(int dx, int dy) {
        for (CoordinateItem<Tile> tile : tiles) {
            tile.item.move(dx, dy);
        }
    }

    // Getters and setters

    /**
     * @return the tiles of this level
     */
    public Grid<Tile> getTiles() {
        return this.tiles;
    }

    /**
     * @return a grid representing the tile map of this level
     */
    public Grid<Integer> getTileMap() {
        return this.tileMap;
    }
}