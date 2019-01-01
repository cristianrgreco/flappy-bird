package com.cristianrgreco.flappybird;

import java.awt.*;

class EndGameView extends AbstractJPanelView {

    EndGameView(ViewTransition viewTransition) {
        super(new KeyBinding(' ', "RESTART", e -> viewTransition.transition()));
    }


    @Override
    public void render(Graphics2D g) {
        g.drawString("PRESS SPACE TO RESTART", 0, 20);
    }

}