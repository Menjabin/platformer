package com.example;

import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

public class App {
    GameManager gameManager;

    // Create a new GameManager, which will start the game
    App() throws IOException {
        gameManager = new GameManager();
    }

    public static void main( String[] args ) throws IOException, InterruptedException {
        App app = new App();
        app.gameLoop();
    }

    public void gameLoop() throws InterruptedException {
        // The gameloop will call the appropriate methods of gameManager
        Timer gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                gameManager.update();
                
            }  
        }, 0, 17);
    }
}
