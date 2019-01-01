package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.cristianrgreco.flappybird.GameView.WINDOW_HEIGHT;
import static com.cristianrgreco.flappybird.GameView.WINDOW_WIDTH;

abstract class AbstractJPanelView implements JPanelView {

    final JPanel panel = createPanel();

    private final List<KeyBinding> keyBindings = new ArrayList<>();


    AbstractJPanelView(KeyBindings... keyBindings) {
        Arrays.stream(keyBindings).forEach(keyBinding -> keyBinding.getKeyBindings().forEach(this.keyBindings::add));
    }

    AbstractJPanelView(KeyBinding... keyBindings) {
        this.keyBindings.addAll(Arrays.asList(keyBindings));
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
    public Collection<KeyBinding> getKeyBindings() {
        return keyBindings;
    }

}
