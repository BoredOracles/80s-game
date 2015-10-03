package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by paul on 03/10/15.
 */
public class Player extends com.mygdx.game.objects.characters.Character {
    private static String TAG = Player.class.getSimpleName();

    int numPlutonium;

    public Player(Sprite sprite, float width, float height) {
        super(sprite, width, height);
        this.numPlutonium = 0;
    }

    @Override
    public void onCollide(Player player) {
        // There's only one player, so this should never be called
        Gdx.app.error(TAG, "Player collided with self");
    }

    public void incPlutoniumCount(){
        incPlutoniumCount(1);
    }

    private void incPlutoniumCount(int numPlutonium){
        this.numPlutonium += numPlutonium;
    }
}
