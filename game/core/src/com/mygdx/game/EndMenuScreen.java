package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by paul on 04/10/15.
 */
public class EndMenuScreen extends MenuScreen {
    private int score;

    public EndMenuScreen(OrkGame game, Texture background) {
        super(game, background);
        this.score = score;
    }

    public void setScore(int score){
        this.score = score;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        SpriteBatch batch = new SpriteBatch();

        BitmapFont font = new BitmapFont();
        font.getData().setScale(2f, 2f);
        font.setColor(Color.GREEN);

        batch.begin();
        font.draw(batch, Integer.toString(getGame().getHighScore()), 360, 310);
        font.draw(batch, Integer.toString(getGame().getCurrentScore()), 360, 280);
        batch.end();

        batch.dispose();
    }

}
