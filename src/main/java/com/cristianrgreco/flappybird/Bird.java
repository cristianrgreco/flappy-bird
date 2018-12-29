package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

import static com.cristianrgreco.flappybird.Panel.WINDOW_HEIGHT;
import static javax.swing.KeyStroke.getKeyStroke;

class Bird implements Model, KeyBindings {

    private static final int WIDTH = 25;
    private static final int HEIGHT = 25;
    private static final double MAX_SPEED = 15;
    private static final double GRAVITY = 0.75;
    private static final double LIFT = 25;

    private double x = 50;
    private double y = (WINDOW_HEIGHT / 3.0) - HEIGHT;
    private double velocity = 0;


    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fill(new Ellipse2D.Double(x, y, WIDTH, HEIGHT));
    }


    @Override
    public void update() {
        setVelocity(velocity + GRAVITY);
        var newY = y + velocity;

        if (isWithinTopBounds(newY) && isWithinBottomBounds(newY)) {
            y = newY;
        } else if (!isWithinTopBounds(newY)) {
            y = 0;
        } else if (!isWithinBottomBounds(newY)) {
            y = WINDOW_HEIGHT - HEIGHT;
        }
    }

    private boolean isWithinTopBounds(double y) {
        return y >= 0;
    }

    private boolean isWithinBottomBounds(double y) {
        return y <= WINDOW_HEIGHT - HEIGHT;
    }


    @Override
    public Iterable<KeyBinding> getKeyBindings() {
        return List.of(new KeyBinding(getKeyStroke(' '), "JUMP", e -> jump()));
    }

    private void jump() {
        setVelocity(velocity - LIFT);
    }


    private void setVelocity(double newVelocity) {
        velocity = clamp(newVelocity, -MAX_SPEED, MAX_SPEED);
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}
