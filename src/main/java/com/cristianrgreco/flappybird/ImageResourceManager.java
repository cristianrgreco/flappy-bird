package com.cristianrgreco.flappybird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class ImageResourceManager implements ResourceManager<ImageResource> {

    private static final int SCALE_FACTOR = 2;

    private final Map<String, ImageResource> cache = new HashMap<>();


    @Override
    public ImageResource getResource(String resourceName) {
        return cache.computeIfAbsent(resourceName, cacheKey -> {
            var image = readImage("/images/" + cacheKey);
            var width = image.getWidth() * SCALE_FACTOR;
            var height = image.getHeight() * SCALE_FACTOR;
            return new ImageResource(image, width, height);
        });
    }

    private BufferedImage readImage(String name) {
        try {
            return ImageIO.read(getClass().getResource(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
