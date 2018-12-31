package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.*;

import static com.cristianrgreco.flappybird.Scale.scale;

class GameView implements JPanelView {

    static final int WINDOW_WIDTH = scale(144);
    static final int WINDOW_HEIGHT = scale(256);

    private final JPanel panel;
    private final Bird bird;
    private final Pipes pipes;
    private final ImageResource backgroundImage;


    GameView(Bird bird, Pipes pipes, ImageResourceManager imageResourceManager) {
        this.panel = createPanel();
        this.bird = bird;
        this.pipes = pipes;
        this.backgroundImage = imageResourceManager.getResource("background.png");
        bird.getKeyBindings().forEach(this::registerKeyBinding);
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
    }


    @Override
    public JPanel getPanel() {
        return panel;
    }

}
