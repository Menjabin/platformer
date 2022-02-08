package com.example;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

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
            player.move(-player.getSpeed(), 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.move(player.getSpeed(), 0);
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
