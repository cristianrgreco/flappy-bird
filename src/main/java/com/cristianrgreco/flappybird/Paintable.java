package com.cristianrgreco.flappybird;

import java.awt.image.ImageObserver;

interface Paintable {

    void paint(Graphics graphics, ImageObserver imageObserver);

    void update();

}
