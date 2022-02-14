package com.example;

import java.awt.*;
import javax.swing.*;

import com.example.entity.Player;
import com.example.tile.Tile;
import com.example.utility.Vector2D;

public class GamePanel extends JPanel implements Runnable {
    // Tiling and the window dimensions
    public static final int ACTUALTILESIZE = 16;
    public static final int SCALE = 4;

    public static final int TILESIZE = ACTUALTILESIZE * SCALE;

    public static final int MAXSCREENCOL = 10;
    public static final int MAXSCREENROW = 6;

    public static final int WIDTH = TILESIZE * MAXSCREENCOL;
    public static final int HEIGHT = TILESIZE * MAXSCREENROW;

    public static Boolean keyRight;
    public static Boolean keyLeft;

    Player player;
    Level level;

    int FPS = 60;

    Thread gameThread;

    /**
     * Does the following:
     * 
     * 1. Create the window.
     * 2. Create the player.
     * 3. Create the level and generate all its sprites.
     * 4. Create the UI.
     * 5. Create a canvas.
     * 6. Configure window behavior and canvas bufferstrategy.
     * 7. Add the input listeners to the canvas
     */
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(173, 216, 230));
        setDoubleBuffered(true);

        // Create the player and add it to the panel
        player = new Player(new Vector2D(100, 10), "player.png");
                
        // Generate the level and add all of the sprites to the panel
        level = new Level();
        level.generateLevel();

        // Create a canvas and add it to the panel
        //Canvas canvas = new Canvas();
        //canvas.setBounds(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        //canvas.setIgnoreRepaint(false);
        
        //add(canvas);

        // Define the buffer strategy
        //canvas.createBufferStrategy(2);
        
        //canvas.requestFocus();
                
        // Add our custom keylistener
        keyRight = keyLeft = false;
        addKeyListener(new KeyboardListener(player));

        requestFocus();
    }

    /**
     * Called every frame.
     * 
     * Updates the position of the camera and the player.
     * Checks for collisions between the player and other sprites
     */
    public void update() {
        moveCamera();
        player.move();
        player.checkCollision(level.getTiles());
        // render
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

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;

        player.draw(graphics);
        for (Tile tile : level.getTiles()) {
            tile.draw(graphics);
        } 

        graphics.dispose();
    }
}
