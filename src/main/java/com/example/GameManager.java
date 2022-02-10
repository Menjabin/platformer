package com.example;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class GameManager {
    // Dimensions of the game window
    final int WIDTH = 800;
    final int HEIGHT = 600;

    JFrame frame;
    Canvas canvas;
    Player player;

    Ground ground;
    Ground ground1;

    GameManager() throws IOException {
        // The main window
        frame = new JFrame("Platformer");

        // Get the panel of the window. We will populate the panel with different widgets
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);

        // Load image and add it to the panel
        player = new Player(new Vector2D(0, 0));
        panel.add(player.getPlayer());

        // Load ground and add it to the panel
        ground = new Ground(new Vector2D(0, 400));
        panel.add(ground.getGround());

        ground1 = new Ground(new Vector2D(400, 300));
        panel.add(ground.getGround());

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
        player.checkCollision(ground.getHitBox());
        player.checkCollision(ground1.getHitBox());
        // render
    }
}
