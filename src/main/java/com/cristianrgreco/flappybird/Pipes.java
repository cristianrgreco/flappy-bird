package com.cristianrgreco.flappybird;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Pipes implements Model {

    private static final int RESPAWN_RATE = 120;

    private final List<Pipe> pipes = new ArrayList<>();

    private long frameCount = 0;


    @Override
    public void paint(Graphics2D g) {
        pipes.forEach(pipe -> pipe.paint(g));
    }

    @Override
    public void update() {
        frameCount++;

        if (shouldAddPipe()) {
            pipes.add(new Pipe());
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

}
