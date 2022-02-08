package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Player {
    public Boolean isJumping = false;

    private JLabel player;
    private Position position;

    private int width = 70;
    private int height = 74;

    private int speed = 10;

    Player(Position startPos) throws IOException {
        BufferedImage img = ImageIO.read(new File("/Users/benjamin/Documents/Programmering/Platformer/platformer/src/main/java/com/example/player.png"));
        player = new JLabel(new ImageIcon(img));
        position = startPos;
        player.setBounds(position.getX(), position.getY(), position.getX() + width, position.getY() + height);
    }

    public int getSpeed() {
        return speed;
    }

    public JLabel getPlayer() {
        return player;
    }

    public Position getPosition() {
        return position;
    }

    public void move(int x, int y) {
        position.move(x, y);
        player.setBounds(position.getX(), position.getY(), position.getX() + width, position.getY() + height);
    }

    public void jump() throws InterruptedException {
        isJumping = true;
        int gravity = 2;
        int jumpSpeed = 15;
        int startY = position.getY();
        
        while (isJumping) {
            move(0, -jumpSpeed);
            jumpSpeed -= gravity;

            if (position.getY() == startY) {
                isJumping = false;
            } else {
                Thread.sleep(50);
            }
        }

        Timer timer = new Timer(jumpSpeed, null);
        timer.setInitialDelay(jumpSpeed);
        timer.start();
    }
}
