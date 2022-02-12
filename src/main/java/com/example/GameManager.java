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

    GameManager() {
        // The main window
        frame = new JFrame("Platformer");

        // Get the panel of the window. We will populate the panel with different widgets
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);

        panel.setBackground(new Color(173, 216, 230));

        // Load image and add it to the panel
        player = new Player(new Vector2D(380, 10), "player.png");
        panel.add(player.getImage());

        // Generate the level
        level = new Level();
        level.generateLevel();

        for (Sprite sprite : level.getSprites()) {
            panel.add(sprite.getImage());
        }

        // UI stuff
        UI ui = new UI();
        panel.add(ui.getUi());

        // Add a canvas to the panel
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(false);

        panel.add(canvas);

        // Define the frame behavior
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);

        canvas.requestFocus();

        // Add our custom keylistener
        keyRight = keyLeft = false;
        canvas.addKeyListener(new KeyboardListener(player));
    }

    public void update() {
        moveCamera();
        player.move();
        player.checkCollision(level.getSprites());
        // render
    }

    public void moveCamera() {
        Vector2D momentum = new Vector2D();

        if (keyRight && keyLeft) {
            momentum.setX(0);
        } else if (keyRight) {
            momentum.setX(-10);
        } else if (keyLeft) {
            momentum.setX(10);
        }

        for (Sprite sprite : level.getSprites()) {
            sprite.move(momentum.getX(), 0);
        } 
    }
}
