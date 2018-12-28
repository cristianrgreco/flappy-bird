package com.cristianrgreco.flappybird;

import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

class GameLoop {

    private final Window window;
    private final ScheduledExecutorService executorService;


    GameLoop(Window window, ScheduledExecutorService executorService) {
        this.window = window;
        this.executorService = executorService;
    }


    void start() {
        executorService.scheduleAtFixedRate(window::repaint, 0, 16, MILLISECONDS);
    }

}
