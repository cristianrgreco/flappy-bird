package com.cristianrgreco.flappybird;

import java.awt.*;

class StartGameView extends AbstractJPanelView {

    StartGameView(ViewTransition viewTransition) {
        super(new KeyBinding(' ', "START", e -> viewTransition.transition()));
    }


    @Override
    public void render(Graphics2D g) {
        g.drawString("PRESS SPACE TO START", 0, 20);
    }

}
