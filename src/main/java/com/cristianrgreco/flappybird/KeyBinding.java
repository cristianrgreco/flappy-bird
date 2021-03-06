package com.cristianrgreco.flappybird;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

class KeyBinding {

    private final KeyStroke keyStroke;
    private final Object actionName;
    private final Action action;


    KeyBinding(char keyChar, Object actionName, Consumer<ActionEvent> eventConsumer) {
        this.keyStroke = KeyStroke.getKeyStroke(keyChar);
        this.actionName = actionName;
        this.action = new ActionCreator(eventConsumer);
    }


    KeyStroke getKeyStroke() {
        return keyStroke;
    }

    Object getActionName() {
        return actionName;
    }

    Action getAction() {
        return action;
    }

}
