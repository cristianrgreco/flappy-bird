package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.*;

class StartGameView extends AbstractJPanelView {

    StartGameView(ViewTransition viewTransition) {
        super(new KeyBinding(KeyStroke.getKeyStroke(' '), "START", e -> viewTransition.transition()));
    }


    @Override
    public void render(Graphics2D g) {
        g.drawString("PRESS SPACE TO START", 0, 20);
    }

}
