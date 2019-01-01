package com.cristianrgreco.flappybird;

class JFrameViewManager {

    private JFrameWindow window;


    JFrameViewManager(JFrameWindow window) {
        this.window = window;
    }


    void setView(JPanelView view) {
        window.setView(view);
        view.getKeyBindings().forEach(keyBinding -> registerKeyBinding(view, keyBinding));
        view.getPanel().requestFocus();
    }

    private void registerKeyBinding(JPanelView view, KeyBinding keyBinding) {
        view.getPanel().getInputMap().put(keyBinding.getKeyStroke(), keyBinding.getActionName());
        view.getPanel().getActionMap().put(keyBinding.getActionName(), keyBinding.getAction());
    }

}
