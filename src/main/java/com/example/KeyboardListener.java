package com.example;

import java.awt.event.*;

public class KeyboardListener implements KeyListener {
    private Player player;
    private GameManager gameManager;

    KeyboardListener(Player player, GameManager gameManager) {
        this.player = player;
        this.gameManager = gameManager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                player.jump();
                return;
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                player.setKeyLeft(true);
                return;
            case KeyEvent.VK_A:
                player.setKeyLeft(true);
                return;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                player.setKeyRight(true);
                return;
            case KeyEvent.VK_D:
                player.setKeyRight(true);
                return;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            // The left key (left arrow or a) is down
            case KeyEvent.VK_LEFT:
                player.setKeyLeft(false);
                return;
            case KeyEvent.VK_A:
                player.setKeyLeft(false);
                return;
            // The right key (right arrow or d) is down
            case KeyEvent.VK_RIGHT:
                player.setKeyRight(false);
                return;
            case KeyEvent.VK_D:
                player.setKeyRight(false);
                return;
        }
    }
}
