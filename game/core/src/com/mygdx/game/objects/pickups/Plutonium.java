package com.mygdx.game.objects.pickups;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public class Plutonium extends Pickup {
    public Plutonium(Sprite sprite, float width, float height) {
        super(sprite, width, height);
    }

    @Override
    public void onCollide(Player player) {
        player.incScore(5);
    }

}
