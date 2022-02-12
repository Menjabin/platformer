package com.example;

public class Ground extends Sprite {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 68;

    private int offsetY = 25;

    Ground(Vector2D position, String assetName) {
        super(position, WIDTH, HEIGHT, assetName);
        hitBox.translate(0, offsetY);
        hitBox.setSize(WIDTH, HEIGHT - offsetY);
    }
}