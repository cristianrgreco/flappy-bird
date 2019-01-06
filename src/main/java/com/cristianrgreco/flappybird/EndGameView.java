package com.cristianrgreco.flappybird;

class EndGameView extends AbstractJPanelView {

    EndGameView(ViewTransition viewTransition) {
        super(new KeyBinding(' ', "RESTART", e -> viewTransition.transition()));
    }


    @Override
    public void render(Graphics graphics) {
        graphics.run(g -> g.drawString("PRESS SPACE TO RESTART", 0, 20));
    }

}
