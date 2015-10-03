package com.mygdx.game.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.InfiniteScrollingScreen;

/**
 * Created by paul on 03/10/15.
 */
public class SpriteSheet extends Sprite {
    private Animation animation;
    private final Texture spriteSheet;
    private final int cols;
    private final int rows;
    private final TextureRegion[] frames;

    public SpriteSheet(Texture spriteSheet, int rows, int cols, float refreshRate){
        this.spriteSheet = spriteSheet;
        this.rows = rows;
        this.cols = cols;

        TextureRegion[][] tmp = TextureRegion.split(spriteSheet, spriteSheet.getWidth()/cols, spriteSheet.getHeight()/rows);
        frames = new TextureRegion[cols * rows];

        int frameIndex = 0;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                frames[frameIndex++] = tmp[i][j];
            }
        }

        animation = new Animation(refreshRate, frames);
    }

    public TextureRegion getCurrentFrame(){
        return animation.getKeyFrame(InfiniteScrollingScreen.getStateTime(), true);
    }
}
