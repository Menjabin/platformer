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

    Ground[] grounds;

    GameManager() throws IOException {
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
        grounds = new Ground[2];
        grounds[0] = new Ground(new Vector2D(0, 400), "ground.png");
        grounds[1] = new Ground(new Vector2D(400, 300), "ground.png");

        panel.add(grounds[0].getImage());
        panel.add(grounds[1].getImage());

        //UI ui = new UI();
        //panel.add(ui.getHeart());

        // Add a canvas to the panel
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(false);

        panel.add(canvas);

        // Define behavior of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);

        canvas.requestFocus();

        canvas.addKeyListener(new KeyboardListener(player, this));
        /*
        canvas.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent arg0) {
                
            }

            @Override
            public void mouseMoved(MouseEvent arg0) {
                System.out.println(arg0.getPoint());
            }
            
        });
        */
    }

    public void update() {
        player.move();
        player.checkCollision(grounds);
        // render
    }
}
