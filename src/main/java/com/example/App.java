package com.example;

import javax.lang.model.type.PrimitiveType;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class App extends Application {
    public static void main(String[] args) {
/*      

        // The game panel controls game logic and rendering
        GamePanel gamePanel = new GamePanel(window);
        window.add(gamePanel);

        window.pack();
        
        // Display the window
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Start the game
        gamePanel.startGameThread(); */

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Platformer");

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(800, 600);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, 800, 600);

        primaryStage.show();

        //GameManager gameManager = new GameManager();

        //gameManager.run();
    }
}