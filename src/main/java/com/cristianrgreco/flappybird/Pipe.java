package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.ThreadLocalRandom;

import static com.cristianrgreco.flappybird.Window.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.Window.WINDOW_WIDTH;

class Pipe implements Model {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 250;
    private static final double SPEED = 2;

    private double x = WINDOW_WIDTH;
    private double y = 0;
    private double offset = ThreadLocalRandom.current().nextInt(-125, 125);


    @Override
    public void paint(Graphics2D g) {
        g.fill(new Rectangle2D.Double(x, y, WIDTH, HEIGHT + offset));
        g.fill(new Rectangle2D.Double(x, WINDOW_HEIGHT - HEIGHT + offset, WIDTH, HEIGHT - offset));
    }

    @Override
    public void update() {
        x -= SPEED;
    }


    boolean isWithinBounds() {
        return x + WIDTH >= 0;
    }

}
