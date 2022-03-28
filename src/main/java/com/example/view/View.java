package com.example.view;

import java.awt.*;
import javax.swing.*;

import com.example.model.entity.Player;
import com.example.model.tile.Tile;

public class View extends JPanel {
    {
        this.setFocusable(true);
    }

    // Tile and window dimensions
    public static final int TILESIZE = 16;

    public static final int MAXSCREENCOL = 40;
    public static final int MAXSCREENROW = 23;

    public static final int WIDTH = 640;
    public static final int HEIGHT = 360;

    public int width = WIDTH;
    public int height = HEIGHT;

    Viewable model;

    int FPS = 60;
    static int scale = 1;

    /**
     * Creates a JPanel which is where the game will happen
     * Creates the player and the current level
     * Adds our custom keylistener for input
     * 
     * @param window The main window
     */
    public View(Viewable model) {
        this.model = model;

        // Configure this panel
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(173, 216, 230));
        setDoubleBuffered(true);
    }

    /**
     * Check if the screen has been resized.
     * Adjust the scale if the screen is large or small enough.
     * If the screen is not large or small enough to change scale, just add black borders
     */
    public void updateScreenSize() {
        Dimension currentSize = getSize();

        int scaleX = (int) currentSize.getWidth() / (WIDTH);
        int scaleY = (int) currentSize.getHeight() / (HEIGHT);

        scale = Math.min(scaleX, scaleY);
    }

    /**
     * Called every frame.
     * 
     * Paints all the tiles and entities.
     * 
     * @param g The graphics to draw this panel on
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;

        drawPlayer(graphics);
        drawLevel(graphics);
    }

    public void drawPlayer(Graphics2D g) {
        Player player = model.getPlayer();

        g.drawImage(player.getImage(), 
            translateToScale(player.getPosition().getX()), 
            translateToScale(player.getPosition().getY()), 
            translateToScale(Player.WIDTH), 
            translateToScale(Player.HEIGHT), 
        null
        );
    }

    public void drawLevel(Graphics2D g) {
        for (Tile tile : model.getTiles()) {
            tile.draw(g);
        }
    }

    /**
     * Adjusts the input value to the window scale
     * 
     * @param value The value to translate
     * @return The input value adjusted to the current scale of the window
     */
    public static int translateToScale(int value) {
        return value * scale;
    }
}