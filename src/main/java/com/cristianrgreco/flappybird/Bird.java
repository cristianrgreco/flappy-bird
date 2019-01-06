package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.util.Collection;
import java.util.List;

import static com.cristianrgreco.flappybird.GameView.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.GameView.WINDOW_WIDTH;
import static com.cristianrgreco.flappybird.Scale.scale;

class Bird implements Paintable, Collidable, KeyBindings {

    private static final int HEIGHT = scale(12);
    private static final int WIDTH = scale(17);
    private static final int FLAP_INTERVAL = 5;
    private static final double GRAVITY = scale(0.16);
    private static final double MAX_SPEED = scale(3.5);
    private static final double LIFT = scale(5);

    private final Ground ground;
    private final ResourceRotator<ImageResource> birdImageResourceRotator;

    private double x = WINDOW_WIDTH / 2.0 - WIDTH;
    private double y = WINDOW_HEIGHT / 2.0 - HEIGHT;
    private double velocity = 0;

    private ImageResource birdImage;


    Bird(Ground ground, ImageResourceManager imageResourceManager) {
        this.ground = ground;
        this.birdImageResourceRotator = new ResourceRotator<>(FLAP_INTERVAL, List.of(
                imageResourceManager.getResource("bird-0.png"),
                imageResourceManager.getResource("bird-1.png"),
                imageResourceManager.getResource("bird-2.png")
        ));
    }


    @Override
    public void paint(Graphics2D g, ImageObserver imageObserver) {
        birdImage.paint(g, x, y, imageObserver);
    }

    @Override
    public void update() {
        birdImageResourceRotator.tick();
        birdImage = birdImageResourceRotator.getResource();

        setVelocity(velocity + GRAVITY);
        y += velocity;
    }


    @Override
    public Collection<Shape> getShapes() {
        return List.of(new Ellipse2D.Double(x, y, birdImage.getWidth(), birdImage.getHeight()));
    }


    @Override
    public Iterable<KeyBinding> getKeyBindings() {
        return List.of(new KeyBinding(' ', "JUMP", e -> jump()));
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


    boolean isWithinBounds() {
        return y >= 0 && y + birdImage.getHeight() <= WINDOW_HEIGHT - ground.getHeight();
    }

}
