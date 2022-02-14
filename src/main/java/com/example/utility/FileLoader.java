package com.example.utility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class FileLoader {
    /**
     * Loads the given image
     * 
     * @param asset The path to the asset relative to resources/assets/, including the file extension
     * @return The image, null if the image is not found
     */
    public BufferedImage loadImage(String asset) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(asset);

            return ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}