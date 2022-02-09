package com.example;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class GameManager {
    // Dimensions of the game window
    final int WIDTH = 800;
    final int HEIGHT = 600;

    JFrame frame;
    Canvas canvas;
    Player player;

    GameManager() throws IOException {
        // The main window
        frame = new JFrame("Platformer");

        // Get the panel of the window. We will populate the panel with different widgets
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);

        // Load image and add it to the panel
        player = new Player(new Vector2D(50, 300));
        panel.add(player.getPlayer());

        //UI ui = new UI();
        //panel.add(ui.getHeart());

        // Add a canvas to the panel
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);

        // Define behavior of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);

        canvas.requestFocus();

        canvas.addKeyListener(new KeyboardListener(player, this));
    }

    public void update() {
        player.move();
        // processInput
        // render
    }
}
