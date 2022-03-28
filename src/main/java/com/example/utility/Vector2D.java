package com.example.utility;

public class Vector2D {
    private int x;
    private int y;

    /**
     * Creates a vector with components x and y
     * 
     * @param x The vector's x component
     * @param y The vector's y component
     */
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Alternative constructor to create a zero vector
     */
    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Translates this vector by x and y
     * 
     * @param x Change in x direction
     * @param y Change in y direction
     */
    public void translate(int x, int y) {
        this.x += x;
        this.y += y;
    }

    /**
     * @return The absolute value of this vector
     */
    public int abs() {
        return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Vector2D)) {
            return false;
        }

        Vector2D vector2dObject = (Vector2D) obj;
        return this.x == vector2dObject.x && this.y == vector2dObject.y;
    }

    // Getters and setters

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
