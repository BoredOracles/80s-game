package com.mygdx.game.objects.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.Collidable;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Projectile extends Collidable {
    public Projectile(Sprite sprite) {
        super(sprite);
    }


}
