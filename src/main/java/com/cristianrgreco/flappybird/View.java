package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static com.cristianrgreco.flappybird.Scale.scale;

abstract class View extends JPanel implements KeyBindingSupport {

    static final int WINDOW_WIDTH = scale(144);
    static final int WINDOW_HEIGHT = scale(256);


    View(KeyBindings... keyBindings) {
        super(true);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        registerKeyBindings(keyBindings);
    }

    private void registerKeyBindings(KeyBindings[] keyBindings) {
        Arrays.stream(keyBindings).forEach(keyBinding ->
                keyBinding.getKeyBindings().forEach(aKeyBinding ->
                        registerKeyBinding(aKeyBinding, getInputMap(), getActionMap())));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render((Graphics2D) g);
    }

    abstract void render(Graphics2D g);

}
