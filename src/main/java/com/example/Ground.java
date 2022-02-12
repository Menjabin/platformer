package com.example;

public class Ground extends Sprite {
    private Rectangle hitBox;

    private int width = 400;
    private int height = 68;

    private int offsetY = 25;

    Ground(Vector2D position, String assetName) {
        super(assetName);
        this.position = position;
        this.hitBox = new Rectangle(new Vector2D(this.position.getX(), this.position.getY() + offsetY), width, height - offsetY);

        image.setBounds(this.position.getX(), this.position.getY(), width, height);
    }

    public Rectangle getHitBox() {
        return hitBox;
    }
}
