package com.cristianrgreco.flappybird;

class StartGameView extends AbstractJPanelView {

    StartGameView(ViewTransition viewTransition) {
        super(new KeyBinding(' ', "START", e -> viewTransition.transition()));
    }


    @Override
    public void render(Graphics graphics) {
        graphics.run(g -> g.drawString("PRESS SPACE TO START", 0, 20));
    }

}
