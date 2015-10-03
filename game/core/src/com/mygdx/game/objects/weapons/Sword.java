package com.mygdx.game.objects.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public class Sword extends MeleeWeapon {

    public Sword(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void onCollide(Player player) {

    }
}
