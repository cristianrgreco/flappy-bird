package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static com.cristianrgreco.flappybird.Panel.WINDOW_HEIGHT;

class Bird implements Model {

    private static final int WIDTH = 25;
    private static final int HEIGHT = 25;
    private static final double GRAVITY = 0.2;

    private double x = 50;
    private double y = (WINDOW_HEIGHT / 3.0) - HEIGHT;
    private double velocity = 0;

    private boolean hasCrashed = false;


    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fill(new Rectangle2D.Double(x, y, WIDTH, HEIGHT));
    }

    @Override
    public void update() {
        if (hasCrashed) {
            return;
        }

        velocity += GRAVITY;
        var newY = y + velocity;

        if (isWithinBounds(newY)) {
            y = newY;
        } else {
            hasCrashed = true;
            y = WINDOW_HEIGHT - HEIGHT;
        }
    }

    private boolean isWithinBounds(double y) {
        return y >= 0 && y <= WINDOW_HEIGHT - HEIGHT;
    }

}
