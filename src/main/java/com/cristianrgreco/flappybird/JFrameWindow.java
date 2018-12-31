package com.cristianrgreco.flappybird;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class JFrameWindow implements Window {

    private final JFrame frame;
    private final String title;


    JFrameWindow(String title) {
        this.frame = new JFrame();
        this.title = title;
    }


    @Override
    public void repaint() {
        frame.repaint();
    }

    @Override
    public void display() {
        frame.pack();
        frame.setTitle(title);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    void setView(JPanelView view) {
        frame.add(view.getPanel());
    }

}
