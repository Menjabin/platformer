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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.jump();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.addMomentum(-10, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.addMomentum(0, 10);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
