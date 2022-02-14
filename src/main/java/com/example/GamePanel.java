package com.example;

import java.awt.*;
import javax.swing.*;

import com.example.sprites.Player;
import com.example.sprites.Sprite;
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

    Player player;
    Level level;

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
        player = new Player(new Vector2D(380, 10), "player.png");
        add(player.getImage());
                
        // Generate the level and add all of the sprites to the panel
        level = new Level();
        level.generateLevel();
                
        for (Sprite sprite : level.getSprites()) {
            add(sprite.getImage());
        }
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
        player.checkCollision(level.getSprites());
        // render
    }

    /**
     * Check which keys are pressed, and move the camera accordingly.
     * The camera is not actually moved, we just move all the sprites other than the player
     */
    public void moveCamera() {
        Vector2D momentum = new Vector2D();

        // Set the momentum
        if (App.keyRight && App.keyLeft) {
            momentum.setX(0);
        } else if (App.keyRight) {
            momentum.setX(-10);
        } else if (App.keyLeft) {
            momentum.setX(10);
        }

        // Move all the sprites in the level
        for (Sprite sprite : level.getSprites()) {
            sprite.move(momentum.getX(), 0);
        } 
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            // Update game logic
            update();
            // Paint everything again
            repaint();
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2d = (Graphics2D) graphics;

        graphics2d.setColor(Color.white);
        graphics2d.fillRect(100, 100, TILESIZE, TILESIZE);

        graphics2d.dispose();
    }
}
