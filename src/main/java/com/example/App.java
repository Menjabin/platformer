package com.example;

import java.io.IOException;

public class App {
    GameManager gameManager;

    // The App constructor will create the window
    App() throws IOException {
        gameManager = new GameManager();
    }

    public static void main( String[] args ) throws IOException, InterruptedException {
        App app = new App();
        app.gameLoop();
    }

    public void gameLoop() throws InterruptedException {
        while (true) {
            gameManager.update();
        }
    }
}
