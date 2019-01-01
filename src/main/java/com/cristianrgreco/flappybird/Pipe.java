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

    private final ImageResource topImage;
    private final ImageResource bottomImage;
    private final int width;
    private final int height;
    private final double offset = ThreadLocalRandom.current().nextInt(-OFFSET, OFFSET);

    private double x = WINDOW_WIDTH;
    private double y = 0;


    Pipe(ImageResourceManager imageResourceManager) {
        this.topImage = imageResourceManager.getResource("obstacle-top.png");
        this.bottomImage = imageResourceManager.getResource("obstacle-bottom.png");
        this.width = topImage.getWidth();
        this.height = topImage.getHeight();
    }


    @Override
    public void paint(Graphics2D g, ImageObserver imageObserver) {
        topImage.paint(g, x, pipeTopY(), width, pipeTopHeight(), imageObserver);
        bottomImage.paint(g, x, pipeBottomY(), width, pipeBottomHeight(), imageObserver);
    }

    @Override
    public void update() {
        x -= SPEED;
    }


    @Override
    public Collection<Shape> getShapes() {
        return List.of(
                new Rectangle2D.Double(x, pipeTopY(), width, pipeTopHeight()),
                new Rectangle2D.Double(x, pipeBottomY(), width, pipeBottomHeight())
        );
    }


    private double pipeTopY() {
        return y - GROUND_HEIGHT;
    }

    private double pipeBottomY() {
        return WINDOW_HEIGHT - height + offset;
    }

    private double pipeTopHeight() {
        return height + offset;
    }

    private double pipeBottomHeight() {
        return height - offset;
    }


    int getWidth() {
        return width;
    }

    boolean isWithinBounds() {
        return x + width >= 0;
    }

}
