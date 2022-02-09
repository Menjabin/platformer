package com.example;

public class PhysicsObject {
    protected int gravity;

    protected Vector2D momentum;
    protected Vector2D position;

    public void setMomentum(int xMomentum, int yMomentum) {
        momentum.setX(xMomentum);
        momentum.setY(yMomentum);
    }

    public void addMomentum(int xMomentum, int yMomentum) {
        momentum.translate(xMomentum, yMomentum);
    }

    public void setMomentumX(int xMomentum) {
        momentum.setX(xMomentum);
    }

    public void setMomentumY(int yMomentum) {
        momentum.setY(yMomentum);
    }
}
