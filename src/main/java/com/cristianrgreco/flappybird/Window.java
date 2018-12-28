package com.cristianrgreco.flappybird;

import javax.swing.*;

class Window extends JFrame {

    void display() {
        pack();
        setTitle("Flappy Bird");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
