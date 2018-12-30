package com.cristianrgreco.flappybird;

import java.awt.*;

class GameView extends View {

    private final Bird bird;
    private final Pipes pipes;
    private final ImageResource backgroundImage;


    GameView(Bird bird, Pipes pipes, ImageResourceManager imageResourceManager) {
        super(bird);
        this.bird = bird;
        this.pipes = pipes;
        this.backgroundImage = imageResourceManager.getResource("background.png");
    }


    @Override
    public void render(Graphics2D g) {
        backgroundImage.paint(g, 0, 0, this);

        bird.update();
        bird.paint(g, this);

        pipes.update();
        pipes.paint(g, this);

        if (pipes.hasCollided(bird)) {
            System.out.println("GAME OVER");
        }
    }

}
