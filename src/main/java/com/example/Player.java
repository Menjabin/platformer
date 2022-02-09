package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends PhysicsObject {
    public Boolean isJumping = false;

    private JLabel player;

    private int width = 70;
    private int height = 74;

    private int startY;
    private Boolean keyLeft = false;
    private Boolean keyRight = false;

    Player(Vector2D startPos) throws IOException {
        String path = System.getProperty("user.dir");
        path += "\\src\\main\\java\\com\\example\\";
        System.out.println(path);
        BufferedImage img = ImageIO.read(new File(path + "player.png"));
        player = new JLabel(new ImageIcon(img));
        position = startPos;
        startY = position.getY();

        momentum = new Vector2D();
        gravity = 2;

        player.setBounds(position.getX(), position.getY(), position.getX() + width, position.getY() + height);
    }

    public void setKeyLeft(Boolean value) {
        keyLeft = value;
    }

    public void setKeyRight(Boolean value) {
        keyRight = value;
    }

    public Vector2D getmomentum() {
        return momentum;
    }

    public JLabel getPlayer() {
        return player;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void move() {
        // Add momentum to the player
        if (keyLeft && keyRight) {
            momentum.setX(0);
        } else if (keyLeft) {
            momentum.setX(-10);
        } else if (keyRight) {
            momentum.setX(10);
        } else {
            // Decrease the momentum whenever no keys are pressed
            if (momentum.getX() > 0) {
                momentum.translate(-1, 0);
            } else if (momentum.getX() < 0) {
                momentum.translate(1, 0);
            }
        }

        position.translate(momentum.getX(), momentum.getY());

        // Process momentum in y-direction
        if (isJumping) {
            momentum.translate(0, gravity);

            if (position.getY() >= startY) {
                position.setY(startY);
                momentum.setY(0);
                isJumping = false;
            }
        }

        player.setBounds(position.getX(), position.getY(), position.getX() + width, position.getY() + height);
    }

    public void jump() {
        if (!isJumping) {
            setMomentumY(-20);
        }

        isJumping = true;
    }
}
