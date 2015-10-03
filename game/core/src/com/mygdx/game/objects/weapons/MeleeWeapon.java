package com.mygdx.game.objects.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.Collidable;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public abstract class MeleeWeapon extends Collidable {
    boolean isAttacking;
    int damage;

    public MeleeWeapon(Sprite sprite, int damage) {
        super(sprite);
        this.damage = damage;
        isAttacking = false;
    }

    @Override
    public void onCollide(Player player) {
        if(isAttacking) player.decHealth(damage);
    }

    @Override
    public void attack() {
        //TODO: Animate and add sound effect
    }
}
