package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Player implements IPhysicsObject {

    private Vector2D momentum;
    private Vector2D position;

    private int gravity;

    public Boolean isJumping = false;

    private JLabel player;

    private Rectangle hitBox;

    private int width = 70;
    private int height = 74;

    private Boolean keyLeft = false;
    private Boolean keyRight = false;

    Player(Vector2D startPos) throws IOException {
        String path = System.getProperty("user.dir");
        path += "\\src\\main\\java\\com\\example\\";
        System.out.println(path);
        BufferedImage img = ImageIO.read(new File(path + "player.png"));
        player = new JLabel(new ImageIcon(img));
        position = startPos;

        momentum = new Vector2D();
        gravity = 2;
        hitBox = new Rectangle(startPos, width, height);

        player.setBounds(position.getX(), position.getY(), width, height);
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

        player.setBounds(position.getX(), position.getY(), width, height);
    }

    public void jump() {
        if (!isJumping) {
            momentum.setY(-30);
        }

        isJumping = true;
    }

    public void checkCollision(Ground[] grounds) {
        Boolean isColliding = false;

        for (Ground other : grounds) {
            if (hitBox.isColliding(other.getHitBox())) {
                isColliding = true;

                isJumping = false;
                position.setY(other.getHitBox().getPosition().getY() - height);
                momentum.setY(0);
            }
        }

        if (!isColliding) {
            momentum.translate(0, gravity);
        }
    }

    // Getters and setters

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
}
