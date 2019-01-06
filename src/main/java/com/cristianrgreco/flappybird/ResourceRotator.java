package com.cristianrgreco.flappybird;

import java.util.List;

class ResourceRotator<T> {

    private final int tickCount;
    private final List<T> resources;

    private int ticks = 0;
    private int resourceIndex = 0;


    ResourceRotator(int tickCount, List<T> resources) {
        this.tickCount = tickCount;
        this.resources = resources;
    }


    void tick() {
        if (ticks % tickCount == 0) {
            resourceIndex++;
        }
        ticks++;
    }

    T getResource() {
        return resources.get(resourceIndex % resources.size());
    }

}
