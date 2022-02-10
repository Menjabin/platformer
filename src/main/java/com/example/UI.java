package com.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class UI {
    private JLabel heart;

    UI() throws IOException {
        BufferedImage img = ImageIO.read(new File("/Users/benjamin/Documents/Programmering/Platformer/platformer/src/main/java/com/example/heart.jpg"));
        heart = new JLabel(new ImageIcon(img));
        heart.setBounds(500, 500, 600, 600);
    }

    public JLabel getHeart() {
        return heart;
    }
}
