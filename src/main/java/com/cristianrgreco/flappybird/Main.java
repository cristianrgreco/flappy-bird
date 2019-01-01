package com.cristianrgreco.flappybird;

import java.awt.*;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var imageResourceManager = new ImageResourceManager();

            var bird = new Bird(imageResourceManager);
            var ground = new Ground(imageResourceManager);
            var pipes = new Pipes(bird, imageResourceManager);
            var score = new Score(imageResourceManager);
            var gameView = new GameView(bird, ground, pipes, score, imageResourceManager);

            var window = new JFrameWindow("Flappy Bird");
            window.setView(gameView);
            window.display();

            new GameLoop(window, newScheduledThreadPool(1)).start();
        });
    }

}
