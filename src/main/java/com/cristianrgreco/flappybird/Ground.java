package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.image.ImageObserver;

import static com.cristianrgreco.flappybird.GameView.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.Scale.scale;

class Ground implements Paintable {

    private static final double SPEED = scale(1.25);
    private static final double RESET = scale(-5);

    private final ImageResource groundImage;

    private double x;
    private double y;


    Ground(ImageResourceManager imageResourceManager) {
        groundImage = imageResourceManager.getResource("ground.png");
        y = WINDOW_HEIGHT - groundImage.getHeight();
    }


    @Override
    public void paint(Graphics2D g, ImageObserver imageObserver) {
        groundImage.paint(g, x, y, imageObserver);
    }

    @Override
    public void update() {
        if (x <= RESET) {
            x = 0;
        } else {
            x -= SPEED;
        }
    }


    int getHeight() {
        return groundImage.getHeight();
    }

}
