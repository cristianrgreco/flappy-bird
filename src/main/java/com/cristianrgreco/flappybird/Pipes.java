package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pipes implements Paintable {

    private static final int RESPAWN_RATE = 90;

    private final Bird bird;
    private final ImageResourceManager imageResourceManager;
    private final List<Pipe> pipes = new ArrayList<>();
    private final Set<Pipe> scoredPipes = new HashSet<>();

    private int score = 0;
    private long frameCount = 0;


    Pipes(Bird bird, ImageResourceManager imageResourceManager) {
        this.bird = bird;
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
                scoredPipes.remove(pipe);
                continue;
            }

            if (hasScored(bird, pipe)) {
                scoredPipes.add(pipe);
                score++;
            }
        }
    }

    private boolean shouldAddPipe() {
        return frameCount % RESPAWN_RATE == 0;
    }

    int getScore() {
        return score;
    }

    private boolean hasScored(Bird bird, Pipe pipe) {
        return !scoredPipes.contains(pipe) && pipe.getShapes().stream().anyMatch(pipeShape ->
                bird.getShapes().stream().anyMatch(birdShape ->
                        birdShape.getBounds2D().getX() > pipeShape.getBounds2D().getX() + (pipe.getWidth() / 2)));
    }

    boolean hasCollided() {
        return pipes.stream().anyMatch(pipe -> pipe.hasCollided(bird));
    }

}
