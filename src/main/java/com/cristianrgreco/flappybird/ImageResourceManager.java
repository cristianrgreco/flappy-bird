package com.cristianrgreco.flappybird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.cristianrgreco.flappybird.Scale.scale;

class ImageResourceManager implements ResourceManager<ImageResource> {

    private final Map<String, ImageResource> cache = new HashMap<>();


    @Override
    public ImageResource getResource(String resourceName) {
        return cache.computeIfAbsent(resourceName, cacheKey -> {
            var image = readImage("/images/" + cacheKey);
            var width = scale(image.getWidth());
            var height = scale(image.getHeight());
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
