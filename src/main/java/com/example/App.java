package com.example;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        // Define window behavior
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Platformer");

        // The game panel controls game logic and rendering
        GamePanel gamePanel = new GamePanel(window);
        window.add(gamePanel);

        window.pack();
        
        // Display the window
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Start the game
        gamePanel.startGameThread();
    }
}