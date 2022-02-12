package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
    // Two dimensional array list for storing the level layout
    // The first dimension is y-coordinates, and the second dimension is x-coordinates
    ArrayList<String[]> layout = new ArrayList<String[]>();

    ArrayList<Sprite> sprites = new ArrayList<Sprite>();

    Level() {
        File file = new File(getClass().getResource("level.txt").getPath());

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                layout.add(sc.nextLine().split(" "));
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateLevel() {
        int widthFactor = 200;
        int heightFactor = (int) GameManager.HEIGHT / layout.size();

        for (int y = 0; y < layout.size(); y++) {
            String[] row = layout.get(y);
            for (int x = 0; x < row.length; x++) {
                if (row[x].equals("1")) {
                    sprites.add(new Ground(new Vector2D(x * widthFactor, y * heightFactor), "ground.png"));
                }
            }
        }
    }

    // Getters and setters

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }
}