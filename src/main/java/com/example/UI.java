package com.example;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class UI {
    private JLabel ui;
    private JLabel heart;

    /**
     * Create the UI and populate it with hearts <3
     */
    UI() {
        ui = new JLabel();
        ui.setBounds(0, 0, 300, 100);

        for (int i = 0; i < 3; i++) {
            try {
                heart = new JLabel(new ImageIcon(ImageIO.read(new File(getClass().getResource("heart.png").getPath()))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            heart.setBounds(0 + 70 * i, 0, 70, 65);
            ui.add(heart);
        }
    }

    // Getters and setters

    public JLabel getUi() {
        return ui;
    }

    public JLabel getHeart() {
        return heart;
    }
}
