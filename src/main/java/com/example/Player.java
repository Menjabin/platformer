package com.example;

import java.util.ArrayList;

public class Player extends Sprite implements IPhysicsObject {
    // Width and height of the player
    public static final int WIDTH = 70;
    public static final int HEIGHT = 74;

    public final int GRAVITY = 2;

    private Boolean isFalling;
    private Vector2D momentum;

    Player(Vector2D startPos, String assetName) {
        super(startPos, WIDTH, HEIGHT, assetName);

        isFalling = true;

        momentum = new Vector2D();
    }

    public void move() {
        // Add momentum to the player
        if (GameManager.keyLeft && GameManager.keyRight) {
            momentum.setX(0);
        } else if (GameManager.keyLeft) {
            momentum.setX(-10);
        } else if (GameManager.keyRight) {
            momentum.setX(10);
        } else {
            // Decrease the momentum whenever no keys are pressed
            if (momentum.getX() > 0) {
                momentum.translate(-1, 0);
            } else if (momentum.getX() < 0) {
                momentum.translate(1, 0);
            }
        }

        if (isFalling) {
            momentum.translate(0, GRAVITY);
        }

        // Move the player
        position.translate(momentum.getX(), momentum.getY());

        hitBox.setBounds(position.getX(), position.getY(), WIDTH, HEIGHT);
        image.setBounds(hitBox);
    }

    public void jump() {
        if (!isFalling) {
            momentum.setY(-30);
        }

        isFalling = true;
    }

    public void checkCollision(ArrayList<Sprite> others) {
        Boolean collision = false;

        for (Sprite other : others) {
            if (isColliding(other)) {
                collision = true;
                isFalling = false;
                position.setY((int) other.getHitBox().getY() - HEIGHT + 1);
                momentum.setY(0);
            }
        }

        if (!collision) {
            isFalling = true;
        }
    }

    // Getters and setters

    public Vector2D getmomentum() {
        return momentum;
    }

    public Vector2D getPosition() {
        return position;
    }
}
