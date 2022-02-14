package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.tile.Tile;
import com.example.utility.FileLoader;
import com.example.utility.Vector2D;

public class Level {
    // Two dimensional array list for storing the level layout
    // The first dimension is y-coordinates, and the second dimension is x-coordinates
    ArrayList<String[]> layout = new ArrayList<String[]>();

    // Contains all the sprites belonging to this level
    ArrayList<Tile> tiles = new ArrayList<Tile>();

    /**
     * Read the level file and store the data in the layout array
     */
    Level() {
        File file = new FileLoader().readFile("levels/level1.tmx");

        try {
            Scanner sc = new Scanner(file);

            for (int i = 0; i < 5; i++) {
                sc.nextLine();
            }

            for (int i = 0; i < GamePanel.MAXSCREENROW; i++) {
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
        int tileSize = GamePanel.ACTUALTILESIZE;

        for (int y = 0; y < layout.size(); y++) {
            String[] row = layout.get(y);
            for (int x = 0; x < row.length; x++) {
                if (row[x].equals("1")) {
                    tiles.add(new Tile(new Vector2D(x * tileSize, y * tileSize), new Vector2D(tileSize, tileSize), "grass.png"));
                }
            }
        }
    }

    // Getters and setters

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}