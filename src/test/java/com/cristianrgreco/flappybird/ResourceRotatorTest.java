package com.cristianrgreco.flappybird;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResourceRotatorTest {

    @Test
    void update_shouldReturnNextResource_whenTickCountIsMet() {
        var tickCount = 1;
        var resources = List.of(
                new ImageResource(null, 100, 100),
                new ImageResource(null, 200, 200)
        );

        var resourceRotator = new ResourceRotator<>(tickCount, resources);

        assertThat(resourceRotator.getResource()).isEqualTo(resources.get(0));
        resourceRotator.tick();
        assertThat(resourceRotator.getResource()).isEqualTo(resources.get(1));
        resourceRotator.tick();
        assertThat(resourceRotator.getResource()).isEqualTo(resources.get(0));
    }

}
