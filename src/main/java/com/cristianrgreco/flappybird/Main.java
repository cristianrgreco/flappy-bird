package com.cristianrgreco.flappybird;

import java.awt.*;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var bird = new Bird();
            var pipes = new Pipes();
            var gameView = new GameView(bird, pipes);
            var window = new Window();

            window.add(gameView);
            window.display();

            new GameLoop(window, newScheduledThreadPool(10)).start();
        });
    }

}
