package com.cristianrgreco.flappybird;

import java.awt.*;

import static com.cristianrgreco.flappybird.Scale.scale;

class GameView extends AbstractJPanelView {

    static final int WINDOW_WIDTH = scale(144);
    static final int WINDOW_HEIGHT = scale(256);

    private final Bird bird;
    private final Pipes pipes;
    private final Ground ground;
    private final ImageResource backgroundImage;


    GameView(Bird bird, Ground ground, Pipes pipes, ImageResourceManager imageResourceManager) {
        super(bird);
        this.bird = bird;
        this.ground = ground;
        this.pipes = pipes;
        this.backgroundImage = imageResourceManager.getResource("background.png");
    }


    @Override
    public void render(Graphics2D g) {
        backgroundImage.paint(g, 0, 0, panel);

        bird.update();
        bird.paint(g, panel);

        pipes.update();
        pipes.paint(g, panel);

        if (pipes.hasCollided(bird)) {
            System.out.println("GAME OVER");
        }

        ground.update();
        ground.paint(g, panel);
    }

}
