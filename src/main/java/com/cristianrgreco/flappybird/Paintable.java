package com.cristianrgreco.flappybird;

import java.awt.*;
import java.awt.image.ImageObserver;

interface Paintable {

    void paint(Graphics2D g, ImageObserver imageObserver);

    void update();

}
