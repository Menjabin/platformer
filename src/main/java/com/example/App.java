package com.example;

import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

public class App {
    // The game manager controls everything. This class just starts the program
    GameManager gameManager;

    // Create a new GameManager, which will start the game
    App() throws IOException {
        gameManager = new GameManager();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        App app = new App();
        app.gameLoop();
    }

    public void gameLoop() throws InterruptedException {
        // Run the game at 60 fps
        Timer gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                // Update the state of the game every frame
                gameManager.update();
            }  
        }, 0, 17);
    }
}