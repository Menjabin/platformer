package com.example;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        // Define window behavior
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Platformer");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();
        
        // Display the window
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}