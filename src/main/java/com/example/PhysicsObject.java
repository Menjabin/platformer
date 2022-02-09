package com.example;

public class PhysicsObject {
    private int gravity;

    protected int xSpeed;
    protected int ySpeed;
    private Position position;

    public void addMomentum(int xMomentum, int yMomentum) {
        xSpeed = xMomentum;
        ySpeed = yMomentum;
    }
}
