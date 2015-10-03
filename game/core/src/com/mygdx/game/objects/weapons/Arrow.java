package com.mygdx.game.objects.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.Collidable;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public class Arrow extends Collidable {
    public Arrow(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void onCollide(Player player) {

    }
}
