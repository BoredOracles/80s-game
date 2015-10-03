package com.mygdx.game.objects.pickups;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.Collidable;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Pickup extends Collidable {

    public Pickup(Sprite sprite) {
        super(sprite);
    }
}
