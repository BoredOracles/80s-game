package com.mygdx.game.objects.characters;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by paul on 03/10/15.
 */
public class Player extends com.mygdx.game.objects.characters.Character {
    int numPlutonium;

    public Player(Sprite sprite) {
        super(sprite);
        this.numPlutonium = 0;
    }

    @Override
    public void onCollide(Player player) {
        // There's only one player, so this should never be called
    }

    public void incPlutoniumCount(){
        incPlutoniumCount(1);
    }

    private void incPlutoniumCount(int numPlutonium){
        this.numPlutonium += numPlutonium;
    }



}
