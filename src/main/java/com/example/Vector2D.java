package com.example;

public class Vector2D {
    private int x;
    private int y;

    Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public void translate(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public int abs() {
        return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return x + ", " + y;
    }
}
