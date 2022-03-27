package com.example;

import java.awt.*;
import javax.swing.*;

import com.example.entity.Player;
import com.example.level.Level;
import com.example.tile.Tile;
import com.example.utility.Vector2D;

public class GamePanel extends JPanel implements Runnable {
    // Tile and window dimensions
    public static final int TILESIZE = 16;

    public static final int MAXSCREENCOL = 40;
    public static final int MAXSCREENROW = 23;

    public static final int WIDTH = 640;
    public static final int HEIGHT = 360;

    public int width = WIDTH;
    public int height = HEIGHT;

    public static Boolean keyRight;
    public static Boolean keyLeft;

    Player player;
    Level level;

    JFrame window;

    int FPS = 60;
    static int scale = 1;

    Thread gameThread;

    /**
     * Creates a JPanel which is where the game will happen
     * Creates the player and the current level
     * Adds our custom keylistener for input
     * 
     * @param window The main window
     */
    public GamePanel(JFrame window) {
        this.window = window;

        // Configure this panel
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(173, 216, 230));
        setDoubleBuffered(true);

        // Create the player
        player = new Player(new Vector2D(WIDTH / 2, HEIGHT / 2), "player.png");

        // Generate the level
        level = new Level();
        level.generateLevel();

        // Add our custom keylistener
        keyRight = keyLeft = false;
        addKeyListener(new KeyboardListener(this, player));

        setFocusable(true);
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
     * Check which keys are pressed, and move the camera accordingly.
     * The camera is not actually moved, we just move all the sprites other than the player
     */
    public void moveCamera() {
        Vector2D momentum = new Vector2D();

        // Set the momentum
        if (keyRight && keyLeft) {
            momentum.setX(0);
        } else if (keyRight) {
            momentum.setX(-10);
        } else if (keyLeft) {
            momentum.setX(10);
        }

        // Move all the sprites in the level
        for (Tile tile : level.getTiles()) {
            tile.move(momentum.getX(), 0);
        } 
    }

    /**
     * Start the game
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Updates every tile and entity, and renders them onto the panel.
     * Makes sure that the main game loop runs at a given FPS
     */
    @Override
    public void run() {
        // How long between each frame
        double drawInterval = 1000000000 / FPS;
        // Helper variables to control FPS
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // Run this as long as the game is running
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                // The main game loop
                update();
                repaint();
                delta--;
            }
        }
    }

    /**
     * Called every frame.
     * 
     * Updates the position of the camera and the player.
     * Checks for collisions between the player and the level tiles
     */
    public void update() {
        updateScreenSize();

        moveCamera();
        player.update();

        player.checkCollision(level.getTiles());
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

        player.draw(graphics);
        for (Tile tile : level.getTiles()) {
            tile.draw(graphics);
        }

        graphics.dispose();
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