package com.cristianrgreco.flappybird;

class Scale {

    private static final int SCALE = 3;


    static int scale(int value) {
        return value * SCALE;
    }

    static double scale(double value) {
        return value * SCALE;
    }

}
