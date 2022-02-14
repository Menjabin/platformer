package com.example;

import java.awt.event.*;

import com.example.entity.Player;

public class KeyboardListener implements KeyListener {
    private Player player;

    /**
     * Takes the player as an argument in order to perform actions on it
     * 
     * @param player The player
     */
    KeyboardListener(Player player) {
        this.player = player;
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                player.jump();
                return;
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                GamePanel.keyLeft = true;
                return;
            case KeyEvent.VK_A:
                GamePanel.keyLeft = true;
                return;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                GamePanel.keyRight = true;
                return;
            case KeyEvent.VK_D:
                GamePanel.keyRight = true;
                return;
        }
    }

    /**
     * Checks which keys that are released.
     * Updates the values of GamePanel.keyLeft and GamePanel.keyRight
     * 
     * @param e The KeyEvent which holds information about which key was released
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                GamePanel.keyLeft = false;
                return;
            case KeyEvent.VK_A:
                GamePanel.keyLeft = false;
                return;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                GamePanel.keyRight = false;
                return;
            case KeyEvent.VK_D:
                GamePanel.keyRight = false;
                return;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
