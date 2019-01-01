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

    private final ImageResource pipeTopImage;
    private final ImageResource pipeBottomImage;
    private final int pipeWidth;
    private final int pipeHeight;
    private final double offset = ThreadLocalRandom.current().nextInt(-OFFSET, OFFSET);

    private double x = WINDOW_WIDTH;
    private double y = 0;


    Pipe(ImageResourceManager imageResourceManager) {
        pipeTopImage = imageResourceManager.getResource("obstacle-top.png");
        pipeBottomImage = imageResourceManager.getResource("obstacle-bottom.png");
        pipeWidth = pipeTopImage.getWidth();
        pipeHeight = pipeTopImage.getHeight();
    }


    @Override
    public void paint(Graphics2D g, ImageObserver imageObserver) {
        pipeTopImage.paint(g, x, pipeTopY(), pipeWidth, pipeTopHeight(), imageObserver);
        pipeBottomImage.paint(g, x, pipeBottomY(), pipeWidth, pipeBottomHeight(), imageObserver);
    }

    @Override
    public void update() {
        x -= SPEED;
    }


    @Override
    public Collection<Shape> getShapes() {
        return List.of(
                new Rectangle2D.Double(x, pipeTopY(), pipeWidth, pipeTopHeight()),
                new Rectangle2D.Double(x, pipeBottomY(), pipeWidth, pipeBottomHeight())
        );
    }


    private double pipeTopY() {
        return y - GROUND_HEIGHT;
    }

    private double pipeBottomY() {
        return WINDOW_HEIGHT - pipeHeight + offset;
    }

    private double pipeTopHeight() {
        return pipeHeight + offset;
    }

    private double pipeBottomHeight() {
        return pipeHeight - offset;
    }


    int getPipeWidth() {
        return pipeWidth;
    }

    boolean isWithinBounds() {
        return x + pipeWidth >= 0;
    }

}
