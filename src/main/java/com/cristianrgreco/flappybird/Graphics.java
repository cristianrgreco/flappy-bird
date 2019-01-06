package com.cristianrgreco.flappybird;

import java.awt.*;
import java.util.function.Consumer;

class Graphics {

    private final Graphics2D g;


    Graphics(Graphics2D g) {
        this.g = g;
    }


    void run(Consumer<Graphics2D> consumer) {
        var graphics = (Graphics2D) g.create();
        consumer.accept(graphics);
        graphics.dispose();
    }

}
