package com.cristianrgreco.flappybird;

import javax.swing.*;

class Window extends JFrame {

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
