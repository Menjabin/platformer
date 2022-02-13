package com.example;

import java.util.Timer;
import java.util.TimerTask;

public class App {
    // The game manager controls everything. This class just starts the program
    GameManager gameManager;

    // Create a new GameManager
    App() {
        // The GameManager constructor initializes everything
        gameManager = new GameManager();
    }

    public static void main(String[] args) {
        App app = new App();
        app.gameLoop();
    }

    /**
     * The gameloop runs in a fixed 60 frames per second
     */
    public void gameLoop() {
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