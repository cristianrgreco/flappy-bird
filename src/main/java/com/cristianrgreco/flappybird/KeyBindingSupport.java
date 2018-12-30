package com.cristianrgreco.flappybird;

import javax.swing.*;

interface KeyBindingSupport {

    default void registerKeyBinding(KeyBinding keyBinding, InputMap inputMap, ActionMap actionMap) {
        inputMap.put(keyBinding.getKeyStroke(), keyBinding.getActionName());
        actionMap.put(keyBinding.getActionName(), keyBinding.getAction());
    }

}
