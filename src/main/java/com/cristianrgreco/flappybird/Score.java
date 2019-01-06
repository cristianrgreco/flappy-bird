package com.cristianrgreco.flappybird;

import java.awt.image.ImageObserver;

import static com.cristianrgreco.flappybird.GameView.WINDOW_WIDTH;
import static java.util.stream.Collectors.toList;

class Score implements Paintable {

    private final ImageResourceManager imageResourceManager;

    private ImageResource scoreImage;
    private String score = "0";
    private int x = 0;
    private int y = 0;


    Score(ImageResourceManager imageResourceManager) {
        this.imageResourceManager = imageResourceManager;
    }


    @Override
    public void paint(Graphics graphics, ImageObserver imageObserver) {
        scoreImage.paint(graphics, x, y, imageObserver);
    }

    @Override
    public void update() {
        var imageResources = score.chars().mapToObj(c -> getResource((char) c)).collect(toList());
        scoreImage = ImageResource.compose(imageResources);
        x = WINDOW_WIDTH / 2 - (scoreImage.getWidth() / 2);
        y = scoreImage.getHeight();
    }

    private ImageResource getResource(char aChar) {
        return imageResourceManager.getResource(aChar + ".png");
    }

    void setScore(int score) {
        this.score = String.valueOf(score);
    }

}
