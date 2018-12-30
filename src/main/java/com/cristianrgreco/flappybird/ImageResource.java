package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.image.ImageObserver;

class ImageResource {

    private final Image image;
    private final int width;
    private final int height;


    ImageResource(Image image, int width, int height) {
        this.image = image;
        this.width = width;
        this.height = height;
    }


    void paint(Graphics2D g, int x, int y, ImageObserver imageObserver) {
        paint(g, x, y, width, height, imageObserver);
    }

    void paint(Graphics2D g, double x, double y, ImageObserver imageObserver) {
        paint(g, (int) x, (int) y, width, height, imageObserver);
    }

    void paint(Graphics2D g, double x, double y, double width, double height, ImageObserver imageObserver) {
        paint(g, (int) x, (int) y, (int) width, (int) height, imageObserver); // todo paint without cast to int
    }

    private void paint(Graphics2D g, int x, int y, int width, int height, ImageObserver imageObserver) {
        g.drawImage(image, x, y, width, height, imageObserver);
    }


    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

}
