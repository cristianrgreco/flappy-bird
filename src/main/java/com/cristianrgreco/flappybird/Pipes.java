package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

class Pipes implements Paintable {

    private static final int RESPAWN_RATE = 100;

    private final List<Pipe> pipes = new ArrayList<>();
    private final ImageResourceManager imageResourceManager;

    private long frameCount = 0;


    Pipes(ImageResourceManager imageResourceManager) {
        this.imageResourceManager = imageResourceManager;
    }


    @Override
    public void paint(Graphics2D g, ImageObserver imageObserver) {
        pipes.forEach(pipe -> pipe.paint(g, imageObserver));
    }

    @Override
    public void update() {
        frameCount++;

        if (shouldAddPipe()) {
            pipes.add(new Pipe(imageResourceManager));
        }

        var pipeIterator = pipes.listIterator();

        while (pipeIterator.hasNext()) {
            var pipe = pipeIterator.next();

            if (pipe.isWithinBounds()) {
                pipe.update();
            } else {
                pipeIterator.remove();
            }
        }
    }

    private boolean shouldAddPipe() {
        return frameCount % RESPAWN_RATE == 0;
    }


    boolean hasCollided(Collidable collidable) {
        return pipes.stream().anyMatch(pipe -> pipe.hasCollided(collidable));
    }

}
