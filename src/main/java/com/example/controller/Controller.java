package com.example.controller;

import java.awt.event.*;

import com.example.model.Model;
import com.example.model.screen.GameScreen;
import com.example.view.View;

public class Controller implements KeyListener, Runnable {
    View view;
    Controllable model;

    // FPS and game thread-related variables
    Thread gameThread;
    boolean isRunning = false;
    private final int FPS = 60;

    /**
     * The controller is responsible for updating the game 60 times per second.
     * It tells the view when to repaint itself, and the model when to move its entities
     * 
     * @param view The game panel
     * @param model The model which contains the current level and player
     */
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        view.addKeyListener(this);
        model.setGameScreen(GameScreen.ACTIVE_GAME);
    }

    /**
     * Start the game thread. This involves setting isRunning to true and creating a new thread
     */
    public void start() {
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            // Controls
            case KeyEvent.VK_SPACE:
                model.jump();
                break;
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                model.setKeyLeft(true);
                break;
            case KeyEvent.VK_A:
                model.setKeyLeft(true);
                break;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                model.setKeyRight(true);
                break;
            case KeyEvent.VK_D:
                model.setKeyRight(true);
                break;
            // Restart the game
            case KeyEvent.VK_R:
                model.restart();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            // The left key (left arrow or a) is released
            case KeyEvent.VK_LEFT:
                model.setKeyLeft(false);
                break;
            case KeyEvent.VK_A:
                model.setKeyLeft(false);
                break;
            // The right key (right arrow or d) is released
            case KeyEvent.VK_RIGHT:
                model.setKeyRight(false);
                break;
            case KeyEvent.VK_D:
                model.setKeyRight(false);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Updates the game 60 times per second.
     * Every update consists of telling the model to update the level, player and other entities,
     * and telling the view to repaint itself
     */
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
                model.tick();
                view.repaint();
                delta--;
            }
        }
    }
}
