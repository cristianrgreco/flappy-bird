package com.cristianrgreco.flappybird;

import java.awt.*;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var imageResourceManager = new ImageResourceManager();

            var bird = new Bird(imageResourceManager);
            var pipes = new Pipes(imageResourceManager);
            var gameView = new GameView(bird, pipes, imageResourceManager);

            var window = new Window();
            window.setView(gameView);
            window.display();

            new GameLoop(window, newScheduledThreadPool(1)).start();
        });
    }

}
