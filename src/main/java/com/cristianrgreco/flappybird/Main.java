package com.cristianrgreco.flappybird;

import java.awt.*;

import static java.util.concurrent.Executors.newScheduledThreadPool;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var imageResourceManager = new ImageResourceManager();
            var window = new JFrameWindow("Flappy Bird");
            var viewManager = new JFrameViewManager(window);
            var startGameView = createStartGameView(viewManager, imageResourceManager);
            viewManager.setView(startGameView);
            window.display();
            new GameLoop(window, newScheduledThreadPool(1)).start();
        });
    }


    private static GameView createGameView(JFrameViewManager viewManager, ImageResourceManager imageResourceManager) {
        var ground = new Ground(imageResourceManager);
        var bird = new Bird(ground, imageResourceManager);
        var pipes = new Pipes(bird, imageResourceManager);
        var score = new Score(imageResourceManager);
        var viewTransition = new ViewTransition(viewManager, () -> createEndGameView(viewManager, imageResourceManager));
        return new GameView(bird, ground, pipes, score, viewTransition, imageResourceManager);
    }

    private static StartGameView createStartGameView(JFrameViewManager viewManager, ImageResourceManager imageResourceManager) {
        var viewTransition = new ViewTransition(viewManager, () -> createGameView(viewManager, imageResourceManager));
        return new StartGameView(viewTransition);
    }

    private static EndGameView createEndGameView(JFrameViewManager viewManager, ImageResourceManager imageResourceManager) {
        var viewTransition = new ViewTransition(viewManager, () -> createGameView(viewManager, imageResourceManager));
        return new EndGameView(viewTransition);
    }

}
