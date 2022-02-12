package com.example;

import java.awt.event.*;

public class KeyboardListener implements KeyListener {
    private Player player;

    KeyboardListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                player.jump();
                return;
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                GameManager.keyLeft = true;
                return;
            case KeyEvent.VK_A:
                GameManager.keyLeft = true;
                return;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                GameManager.keyRight = true;
                return;
            case KeyEvent.VK_D:
                GameManager.keyRight = true;
                return;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                GameManager.keyLeft = false;
                return;
            case KeyEvent.VK_A:
                GameManager.keyLeft = false;
                return;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                GameManager.keyRight = false;
                return;
            case KeyEvent.VK_D:
                GameManager.keyRight = false;
                return;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
