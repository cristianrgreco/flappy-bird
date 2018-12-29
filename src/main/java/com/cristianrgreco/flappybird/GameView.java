package com.cristianrgreco.flappybird;

import java.awt.*;

import static com.cristianrgreco.flappybird.Window.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.Window.WINDOW_WIDTH;

class GameView extends AbstractView {

    private Bird bird;
    private Pipes pipes;


    GameView(Bird bird, Pipes pipes) {
        this.bird = bird;
        this.bird.getKeyBindings().forEach(this::registerKeyBinding);
        this.pipes = pipes;
    }


    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        bird.update();
        bird.paint(g);

        pipes.update();
        pipes.paint(g);

        if (pipes.hasCollided(bird)) {
            System.out.println("GAME OVER");
        }
    }

}
