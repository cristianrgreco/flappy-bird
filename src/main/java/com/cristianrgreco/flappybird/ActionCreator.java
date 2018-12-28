package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

class ActionCreator extends AbstractAction {

    private Consumer<ActionEvent> consumer;


    ActionCreator(Consumer<ActionEvent> consumer) {
        this.consumer = consumer;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        consumer.accept(e);
    }

}
