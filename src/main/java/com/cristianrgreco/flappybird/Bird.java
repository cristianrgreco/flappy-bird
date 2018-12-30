package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.util.Collection;
import java.util.List;

import static com.cristianrgreco.flappybird.Window.WINDOW_HEIGHT;
import static javax.swing.KeyStroke.getKeyStroke;

class Bird implements Paintable, Collidable, KeyBindings {

    private static final double MAX_SPEED = 15;
    private static final double GRAVITY = 0.75;
    private static final double LIFT = 25;

    private final ImageResource birdImage;

    private double x = 50;
    private double y = (WINDOW_HEIGHT / 2.0);
    private double velocity = 0;


    Bird(ImageResourceManager imageResourceManager) {
        birdImage = imageResourceManager.getResource("bird-1.png");
    }


    @Override
    public void paint(Graphics2D g, ImageObserver imageObserver) {
        birdImage.paint(g, x, y, imageObserver);
    }

    @Override
    public void update() {
        setVelocity(velocity + GRAVITY);
        y += velocity;
    }


    @Override
    public Collection<Shape> getShapes() {
        return List.of(new Ellipse2D.Double(x, y, birdImage.getWidth(), birdImage.getHeight()));
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
