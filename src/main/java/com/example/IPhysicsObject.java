package com.example;

public interface IPhysicsObject {
    public void move();

    public void checkCollision(Ground[] other);
}
