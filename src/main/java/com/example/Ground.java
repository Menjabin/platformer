package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ground {
    private Vector2D position;
    private Rectangle hitBox;

    private JLabel ground;

    private int width = 400;
    private int height = 68;

    private int offsetY = 25;

    Ground(Vector2D position) throws IOException {
        this.position = position;
        this.hitBox = new Rectangle(new Vector2D(position.getX(), position.getY() + offsetY), width, height - offsetY);

        String path = System.getProperty("user.dir");
        path += "\\src\\main\\java\\com\\example\\";
        System.out.println(path);
        BufferedImage img = ImageIO.read(new File(path + "ground.png"));
        ground = new JLabel(new ImageIcon(img));

        ground.setBounds(position.getX(), position.getY(), width, height);
    }

    public JLabel getGround() {
        return ground;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }
}
