package com.example;

public class Player extends Sprite implements IPhysicsObject {
    // Width and height of the player
    private final int WIDTH = 70;
    private final int HEIGHT = 74;

    private final int GRAVITY;

    public Boolean isJumping = false;

    private Rectangle hitBox;

    // Keep track of input
    private Boolean keyLeft;
    private Boolean keyRight;

    Player(Vector2D startPos, String assetName) {
        super(assetName);

        position = startPos;

        keyLeft = keyRight = false;

        momentum = new Vector2D();
        GRAVITY = 2;
        hitBox = new Rectangle(startPos, WIDTH, HEIGHT);

        image.setBounds(position.getX(), position.getY(), WIDTH, HEIGHT);
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

        image.setBounds(position.getX(), position.getY(), WIDTH, HEIGHT);
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

    public Vector2D getPosition() {
        return position;
    }
}
