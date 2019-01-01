package com.cristianrgreco.flappybird;

import java.util.function.Supplier;

class ViewTransition {

    private final JFrameViewManager viewManager;
    private final Supplier<JPanelView> viewSupplier;


    ViewTransition(JFrameViewManager viewManager, Supplier<JPanelView> viewSupplier) {
        this.viewManager = viewManager;
        this.viewSupplier = viewSupplier;
    }


    void transition() {
        viewManager.setView(viewSupplier.get());
    }

}
