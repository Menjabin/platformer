package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Player implements IPhysicsObject {
    // Width and height of the player
    private final int WIDTH = 70;
    private final int HEIGHT = 74;

    // 
    private Vector2D position;
    private Vector2D momentum;

    private final int GRAVITY;

    public Boolean isJumping = false;

    private JLabel player;

    private Rectangle hitBox;



    private Boolean keyLeft;
    private Boolean keyRight;

    Player(Vector2D startPos) throws IOException {
        String path = System.getProperty("user.dir");
        path += "\\src\\main\\java\\com\\example\\";
        System.out.println(path);
        BufferedImage img = ImageIO.read(new File(path + "player.png"));
        player = new JLabel(new ImageIcon(img));
        position = startPos;

        momentum = new Vector2D();
        GRAVITY = 2;
        hitBox = new Rectangle(startPos, WIDTH, HEIGHT);

        player.setBounds(position.getX(), position.getY(), WIDTH, HEIGHT);
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

        player.setBounds(position.getX(), position.getY(), WIDTH, HEIGHT);
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
                position.setY(other.getHitBox().getPosition().getY() - HEIGHT);
                momentum.setY(0);
            }
        }

        if (!isColliding) {
            momentum.translate(0, GRAVITY);
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
