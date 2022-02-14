package com.example;

import java.awt.*;
import javax.swing.*;

import com.example.sprites.Player;

public class App {
    public static Boolean keyRight;
    public static Boolean keyLeft;

    public static Player player;

    public static void main(String[] args) {
        JFrame window = new JFrame();

        // Define window behavior
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Platformer");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        // Create a canvas and add it to the panel
        //Canvas canvas = new Canvas();
        //canvas.setBounds(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        //canvas.setIgnoreRepaint(false);
        
        //gamePanel.add(canvas);
        
        // Display the window
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Define the buffer strategy
        //canvas.createBufferStrategy(2);
        
        //canvas.requestFocus();

        //player = gamePanel.player;
        
        // Add our custom keylistener
        keyRight = keyLeft = false;
        //canvas.addKeyListener(new KeyboardListener(player));

        gamePanel.startGameThread();
    }
}