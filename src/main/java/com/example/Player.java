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

    private int startY;
    private int gravity = 2;
    private int jumpSpeed = 30;

    Player(Position startPos) throws IOException {
        String path = System.getProperty("user.dir");
        path += "\\src\\main\\java\\com\\example\\";
        System.out.println(path);
        BufferedImage img = ImageIO.read(new File(path + "player.png"));
        player = new JLabel(new ImageIcon(img));
        position = startPos;
        startY = position.getY();
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

    public void nextStep() {        
        if (isJumping) {
            move(0, -jumpSpeed);
            jumpSpeed -= gravity;

            if (position.getY() >= startY) {
                position.setY(startY);
                isJumping = false;
            }
        }
        System.out.println(position.getX() + ", " + position.getY());
    }

    public void jump() {
        isJumping = true;
    }
}
