package com.cristianrgreco.flappybird;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class JFrameWindow implements Window {

    private final String title;
    private final JFrame frame = new JFrame();


    JFrameWindow(String title) {
        this.title = title;
    }


    @Override
    public void setView(View view) {
        frame.add(view);
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

}
