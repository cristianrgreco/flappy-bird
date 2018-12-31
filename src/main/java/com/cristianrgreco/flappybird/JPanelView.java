package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.*;

import static com.cristianrgreco.flappybird.GameView.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.GameView.WINDOW_WIDTH;

interface JPanelView extends View {

    JPanel getPanel();


    default JPanel createPanel() {
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
    default void registerKeyBinding(KeyBinding keyBinding) {
        getPanel().getInputMap().put(keyBinding.getKeyStroke(), keyBinding.getActionName());
        getPanel().getActionMap().put(keyBinding.getActionName(), keyBinding.getAction());
    }

}
