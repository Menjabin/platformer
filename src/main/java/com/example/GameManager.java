package com.example;

import java.awt.*;
import javax.swing.*;

public class GameManager {
    // Dimensions of the game window
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static Boolean keyRight;
    public static Boolean keyLeft;

    private JFrame frame;
    private Canvas canvas;

    private Player player;
    private Level level;

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
    GameManager() {
        // Create the window
        frame = new JFrame("Platformer");

        // Get the content panel from the window
        // The content panel will hold all our sprites
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);

        panel.setBackground(new Color(173, 216, 230));

        // Create the player and add it to the panel
        player = new Player(new Vector2D(380, 10), "player.png");
        panel.add(player.getImage());

        // Generate the level and add all of the sprites to the panel
        level = new Level();
        level.generateLevel();

        for (Sprite sprite : level.getSprites()) {
            panel.add(sprite.getImage());
        }

        // Create the UI and add it to the panel
        UI ui = new UI();
        panel.add(ui.getUi());

        // Create a canvas and add it to the panel
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);

        // Define the frame behavior
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        // Define the buffer strategy
        canvas.createBufferStrategy(2);

        canvas.requestFocus();

        // Add our custom keylistener
        keyRight = keyLeft = false;
        canvas.addKeyListener(new KeyboardListener(player));
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
        if (keyRight && keyLeft) {
            momentum.setX(0);
        } else if (keyRight) {
            momentum.setX(-10);
        } else if (keyLeft) {
            momentum.setX(10);
        }

        // Move all the sprites in the level
        for (Sprite sprite : level.getSprites()) {
            sprite.move(momentum.getX(), 0);
        } 
    }
}
