package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.image.BufferedImage;
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


    void paint(Graphics graphics, int x, int y, ImageObserver imageObserver) {
        graphics.run(g -> paint(g, x, y, imageObserver));
    }

    void paint(Graphics2D g, int x, int y, ImageObserver imageObserver) {
        paint(g, x, y, width, height, imageObserver);
    }


    void paint(Graphics graphics, double x, double y, ImageObserver imageObserver) {
        graphics.run(g -> paint(g, x, y, imageObserver));
    }

    void paint(Graphics2D g, double x, double y, ImageObserver imageObserver) {
        paint(g, (int) x, (int) y, width, height, imageObserver);
    }


    void paint(Graphics graphics, double x, double y, double width, double height, ImageObserver imageObserver) {
        graphics.run(g -> paint(g, x, y, width, height, imageObserver));
    }

    void paint(Graphics2D g, double x, double y, double width, double height, ImageObserver imageObserver) {
        paint(g, (int) x, (int) y, (int) width, (int) height, imageObserver); // todo paint without cast to int
    }


    private void paint(Graphics2D g, int x, int y, int width, int height, ImageObserver imageObserver) {
        g.drawImage(image, x, y, width, height, imageObserver);
    }


    static ImageResource compose(Iterable<ImageResource> imageResources) {
        var imageSize = calculateCompositionSize(imageResources);
        var bufferedImage = new BufferedImage(imageSize.width, imageSize.height, BufferedImage.TYPE_INT_ARGB);

        var g2d = (Graphics2D) bufferedImage.getGraphics();
        var xOffset = 0;
        for (var imageResource : imageResources) {
            imageResource.paint(g2d, xOffset, 0, null);
            xOffset += imageResource.getWidth();
        }
        g2d.dispose();

        return new ImageResource(bufferedImage, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    private static Dimension calculateCompositionSize(Iterable<ImageResource> imageResources) {
        var width = 0;
        var height = 0;

        for (var imageResource : imageResources) {
            width += imageResource.getWidth();
            height = Math.max(height, imageResource.getHeight());
        }

        return new Dimension(width, height);
    }


    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

}
