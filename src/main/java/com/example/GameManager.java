package com.example;

import java.awt.*;
import javax.swing.*;

public class GameManager {
    // Dimensions of the game window
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;


    JFrame frame;
    Canvas canvas;
    Player player;

    Level level;

    GameManager() {
        // The main window
        frame = new JFrame("Platformer");

        // Get the panel of the window. We will populate the panel with different widgets
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);

        panel.setBackground(new Color(173, 216, 230));

        // Load image and add it to the panel
        player = new Player(new Vector2D(50, 10), "player.png");
        panel.add(player.getImage());

        // Load ground and add it to the panel
        //grounds = new Ground[2];
        //grounds[0] = new Ground(new Vector2D(0, 400), "ground.png");
        //grounds[1] = new Ground(new Vector2D(400, 300), "ground.png");

        //panel.add(grounds[0].getImage());
        //panel.add(grounds[1].getImage());
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
        canvas.addKeyListener(new KeyboardListener(player, this));
    }

    public void update() {
        player.move();
        player.checkCollision(level.getSprites());
        // render
    }
}
