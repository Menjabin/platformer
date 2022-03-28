package com.example;

import javax.swing.*;

import com.example.controller.Controller;
import com.example.model.Model;
import com.example.view.View;

public class App {

    public static final String WINDOW_TITLE = "Platformer";

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(view, model);

        JFrame frame = new JFrame(WINDOW_TITLE);

        // Define window behavior
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        // Add the view to the main window
        frame.setContentPane(view);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        controller.start();
    }
}