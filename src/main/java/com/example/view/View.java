package com.example.view;

import java.awt.*;
import javax.swing.*;

import com.example.grid.CoordinateItem;
import com.example.model.entity.Player;
import com.example.model.screen.GameScreen;
import com.example.model.screen.MainMenu;
import com.example.model.tile.Tile;

public class View extends JPanel {
    {
        // This will run at the very beginning of the program
        this.setFocusable(true);
    }

    // Tile and window dimensions
    public static final int TILESIZE = 16;

    public static final int MAXSCREENCOL = 40;
    public static final int MAXSCREENROW = 23;

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 736;

    public int width = WIDTH;
    public int height = HEIGHT;

    Viewable model;

    int FPS = 60;
    static int scale = Math.min(WIDTH / (MAXSCREENCOL * TILESIZE), HEIGHT / (MAXSCREENROW * TILESIZE));

    MainMenu mainMenu = new MainMenu();

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
     * Draws all the tiles and entities.
     * 
     * @param g the graphics object to draw this panel with
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;

        if (model.getGameScreen() == GameScreen.ACTIVE_GAME) {
            drawLevel(graphics);
            drawPlayer(graphics);
        }
    }

    /**
     * Draws the player
     * 
     * @param g the graphics object to draw with
     */
    public void drawPlayer(Graphics2D g) {
        Player player = model.getPlayer();

        g.drawImage(player.getImage(), 
            player.getPositionX() * scale, 
            player.getPositionY() * scale, 
            Player.WIDTH * scale, 
            Player.HEIGHT * scale,
            null
        );
    }

    /**
     * Draw the level
     * 
     * @param g the graphics object to draw with
     */
    public void drawLevel(Graphics2D g) {
        for (CoordinateItem<Tile> tileItem : model.getTiles()) {
            Tile tile = tileItem.item;

            if (tile != null) {
                g.drawImage(tile.getImage(), 
                    tile.getPositionX() * scale,
                    tile.getPositionY() * scale,
                    tile.getSize() * scale,
                    tile.getSize() * scale,
                    null
                );
            }
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