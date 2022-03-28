package com.example.controller;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;

import com.example.model.Model;
import com.example.utility.Vector2D;
import com.example.view.View;

public class Controller implements KeyListener, Runnable {
    View view;
    Controllable model;

    Boolean fullScreen;

    GraphicsDevice device;

    final int FPS = 60;
    Thread gameThread;
    boolean isRunning = false;

    /**
     * Takes the player as an argument in order to perform actions on it
     * 
     * @param view The game panel
     * @param player The player
     */
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        view.addKeyListener(this);

        fullScreen = false;
        device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    }

    public void start() {
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Checks which keys that are pressed.
     * Updates the values of GamePanel.keyLeft and GamePanel.keyRight.
     * Calls player.jump() whenever the space key is pressed
     * 
     * @param e The KeyEvent which holds information about which key was pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Vector2D movement = new Vector2D();

        switch (e.getKeyCode()) {
            // Controls
            case KeyEvent.VK_SPACE:
                model.jump();
                break;
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                movement.setX(-1);
                break;
            case KeyEvent.VK_A:
                movement.setX(-1);
                break;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                movement.setX(1);
                break;
            case KeyEvent.VK_D:
                movement.setX(1);
                break;
        }

        model.move(movement);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void run() {
        // How long between each frame
        double drawInterval = 1000000000 / FPS;
        // Helper variables to control FPS
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // Run this as long as the game is running
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                // The main game loop
                model.update();
                view.repaint();
                delta--;
            }
        }
    }
}
