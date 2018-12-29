package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.*;

import static com.cristianrgreco.flappybird.Window.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.Window.WINDOW_WIDTH;

abstract class View extends JPanel implements KeyBindingSupport {

    View() {
        super(true);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    }


    @Override
    public void registerKeyBinding(KeyBinding keyBinding) {
        getInputMap().put(keyBinding.getKeyStroke(), keyBinding.getActionName());
        getActionMap().put(keyBinding.getActionName(), keyBinding.getAction());
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render((Graphics2D) g);
    }

    abstract void render(Graphics2D g);

}
