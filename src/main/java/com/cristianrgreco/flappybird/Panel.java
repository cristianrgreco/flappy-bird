package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.*;

class Panel extends JPanel {

    static final int WINDOW_WIDTH = 375;
    static final int WINDOW_HEIGHT = 667;

    private Bird bird;


    Panel(Bird bird) {
        super(true);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        this.bird = bird;
        this.bird.getKeyBindings().forEach(this::registerKeyBinding);
    }


    private void registerKeyBinding(KeyBinding keyBinding) {
        getInputMap().put(keyBinding.getKeyStroke(), keyBinding.getActionName());
        getActionMap().put(keyBinding.getActionName(), keyBinding.getAction());
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPanel((Graphics2D) g);
    }

    private void drawPanel(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        bird.update();
        bird.paint(g);
    }

}
