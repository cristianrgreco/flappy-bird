package com.cristianrgreco.flappybird;

class ViewTransition {

    private final JFrameViewManager viewManager;
    private final JPanelView view;


    ViewTransition(JFrameViewManager viewManager, JPanelView view) {
        this.viewManager = viewManager;
        this.view = view;
    }


    void transition() {
        viewManager.setView(view);
    }

}
