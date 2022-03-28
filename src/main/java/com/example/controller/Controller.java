package com.example.controller;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;

import com.example.model.Model;
import com.example.utility.Vector2D;
import com.example.view.View;

public class Controller implements KeyListener {
    View view;
    Controllable model;

    Boolean fullScreen;

    GraphicsDevice device;

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
                return;
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                movement.setX(-1);
                return;
            case KeyEvent.VK_A:
                movement.setX(-1);
                return;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                movement.setX(1);
                return;
            case KeyEvent.VK_D:
                movement.setX(1);
                return;
        }

        model.move(movement);

        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
