package com.cristianrgreco.flappybird;

import javax.swing.*;

class Window extends JFrame {

    static final int WINDOW_WIDTH = 375;
    static final int WINDOW_HEIGHT = 667;


    void setView(View view) {
        add(view);
    }

    void display() {
        pack();
        setTitle("Flappy Bird");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
