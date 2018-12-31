package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.cristianrgreco.flappybird.GameView.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.GameView.WINDOW_WIDTH;
import static com.cristianrgreco.flappybird.Scale.scale;

class Pipe implements Paintable, Collidable {

    private static final double SPEED = scale(1);
    private static final int OFFSET = scale(60);
    private static final int GROUND_HEIGHT = scale(55);

    private final ImageResource obstacleTopImage;
    private final ImageResource obstacleBottomImage;
    private final int obstacleWidth;
    private final int obstacleHeight;
    private final double offset = ThreadLocalRandom.current().nextInt(-OFFSET, OFFSET);

    private double x = WINDOW_WIDTH;
    private double y = 0;


    Pipe(ImageResourceManager imageResourceManager) {
        obstacleTopImage = imageResourceManager.getResource("obstacle-top.png");
        obstacleBottomImage = imageResourceManager.getResource("obstacle-bottom.png");
        obstacleWidth = obstacleTopImage.getWidth();
        obstacleHeight = obstacleTopImage.getHeight();
    }


    @Override
    public void paint(Graphics2D g, ImageObserver imageObserver) {
        obstacleTopImage.paint(g, x, obstacleTopY(), obstacleWidth, obstacleTopHeight(), imageObserver);
        obstacleBottomImage.paint(g, x, obstacleBottomY(), obstacleWidth, obstacleBottomHeight(), imageObserver);
    }

    @Override
    public void update() {
        x -= SPEED;
    }


    @Override
    public Collection<Shape> getShapes() {
        return List.of(
                new Rectangle2D.Double(x, obstacleTopY(), obstacleWidth, obstacleTopHeight()),
                new Rectangle2D.Double(x, obstacleBottomY(), obstacleWidth, obstacleBottomHeight())
        );
    }


    private double obstacleTopY() {
        return y - GROUND_HEIGHT;
    }

    private double obstacleBottomY() {
        return WINDOW_HEIGHT - obstacleHeight + offset;
    }

    private double obstacleTopHeight() {
        return obstacleHeight + offset;
    }

    private double obstacleBottomHeight() {
        return obstacleHeight - offset;
    }


    boolean isWithinBounds() {
        return x + obstacleWidth >= 0;
    }

}
