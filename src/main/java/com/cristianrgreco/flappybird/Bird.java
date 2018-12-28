package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

import static com.cristianrgreco.flappybird.Panel.WINDOW_HEIGHT;
import static javax.swing.KeyStroke.getKeyStroke;

class Bird implements Model, KeyBindings {

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


    @Override
    public Iterable<KeyBinding> getKeyBindings() {
        return List.of(new KeyBinding(getKeyStroke(' '), "JUMP", e -> jump()));
    }

    private void jump() {
        System.out.println("JUMP");
    }
}
