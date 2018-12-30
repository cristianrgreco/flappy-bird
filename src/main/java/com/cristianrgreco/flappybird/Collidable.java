package com.cristianrgreco.flappybird;

import java.awt.*;
import java.util.Collection;

interface Collidable {

    Collection<Shape> getShapes();


    default boolean hasCollided(Collidable collidable) {
        return getShapes().stream().anyMatch(shape ->
                collidable.getShapes().stream().anyMatch(otherShape ->
                        otherShape.intersects(shape.getBounds2D()))); // todo bounds for an ellipse?
    }

}
