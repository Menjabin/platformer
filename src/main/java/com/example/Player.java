package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends PhysicsObject {
    public Boolean isJumping = false;

    private JLabel player;
    private Vector2D position;

    private int width = 70;
    private int height = 74;

    private Vector2D speed;

    private int startY;
    private int gravity = 2;
    private int jumpSpeed = 30;

    Player(Vector2D startPos) throws IOException {
        String path = System.getProperty("user.dir");
        path += "\\src\\main\\java\\com\\example\\";
        System.out.println(path);
        BufferedImage img = ImageIO.read(new File(path + "player.png"));
        player = new JLabel(new ImageIcon(img));
        position = startPos;
        startY = position.getY();
        player.setBounds(position.getX(), position.getY(), position.getX() + width, position.getY() + height);
    }

    public Vector2D getSpeed() {
        return speed;
    }

    public JLabel getPlayer() {
        return player;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void move() {
        addMomentum(10, 10);



        player.setBounds(position.getX(), position.getY(), position.getX() + width, position.getY() + height);
    }

    public void nextStep() {        
        if (isJumping) {
            addMomentum(0, -jumpSpeed);
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
