package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.cristianrgreco.flappybird.Window.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.Window.WINDOW_WIDTH;

class Pipe implements Paintable, Collidable {

    private static final int GAP = 75;
    private static final double SPEED = 2;

    private final ImageResource obstacleTopImage;
    private final ImageResource obstacleBottomImage;
    private final int obstacleWidth;
    private final int obstacleHeight;
    private final double offset = ThreadLocalRandom.current().nextInt(-125, 125);

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
        var obstacleTop = new Rectangle2D.Double(x, obstacleTopY(), obstacleWidth, obstacleTopHeight());
        var obstacleBottom = new Rectangle2D.Double(x, obstacleBottomY(), obstacleWidth, obstacleBottomHeight());
        return List.of(obstacleTop, obstacleBottom);
    }


    private double obstacleTopY() {
        return y - GAP;
    }

    private double obstacleBottomY() {
        return WINDOW_HEIGHT - obstacleHeight + GAP + offset;
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
