package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static com.cristianrgreco.flappybird.GameView.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.GameView.WINDOW_WIDTH;

abstract class AbstractJPanelView implements JPanelView {

    final JPanel panel;


    AbstractJPanelView(KeyBindings... keyBindings) {
        panel = createPanel();
        Arrays.stream(keyBindings).forEach(keyBinding ->
                keyBinding.getKeyBindings().forEach(this::registerKeyBinding));
    }


    @Override
    public JPanel getPanel() {
        return panel;
    }

    private JPanel createPanel() {
        var panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                render((Graphics2D) g);
            }
        };
        panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        return panel;
    }


    @Override
    public void registerKeyBinding(KeyBinding keyBinding) {
        panel.getInputMap().put(keyBinding.getKeyStroke(), keyBinding.getActionName());
        panel.getActionMap().put(keyBinding.getActionName(), keyBinding.getAction());
    }

}
