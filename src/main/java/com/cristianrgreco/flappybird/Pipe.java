package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.cristianrgreco.flappybird.Window.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.Window.WINDOW_WIDTH;

class Pipe implements Paintable, Collidable {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 250;
    private static final double SPEED = 2;

    private double x = WINDOW_WIDTH;
    private double y = 0;
    private double offset = ThreadLocalRandom.current().nextInt(-125, 125);


    @Override
    public void paint(Graphics2D g) {
        getShapes().forEach(g::fill);
    }

    @Override
    public void update() {
        x -= SPEED;
    }


    @Override
    public Collection<Shape> getShapes() {
        return List.of(
                new Rectangle2D.Double(x, y, WIDTH, HEIGHT + offset),
                new Rectangle2D.Double(x, WINDOW_HEIGHT - HEIGHT + offset, WIDTH, HEIGHT - offset)
        );
    }


    boolean isWithinBounds() {
        return x + WIDTH >= 0;
    }

}
