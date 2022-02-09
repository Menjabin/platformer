package com.example;

public class Rectangle {
    private Vector2D position;
    private int width;
    private int height;

    Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Boolean isColliding(Rectangle other) {
        if (this.position.getX() > other.position.getX() + other.width || this.position.getX() + this.width < other.position.getX()) {
            return false;
        }
        if (this.position.getY() > other.position.getY() + other.height || this.position.getY() + this.height < other.position.getY()) {
            return false;
        }

        return true;
    }


    // Getters and setters

    public Vector2D getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
