package com.example.utility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageLoader {
    public BufferedImage loadImage(String asset) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("assets/" + asset);

            return ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}