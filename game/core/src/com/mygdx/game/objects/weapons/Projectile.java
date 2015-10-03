package com.mygdx.game.objects.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.Collidable;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public class Projectile extends Collidable{
    int damage;

    public Projectile(Sprite sprite, int damage) {
        super(sprite);
        this.damage = damage;
    }

    @Override
    public void onCollide(Player player) {
        player.decHealth(damage);
    }

    @Override
    public void attack() {
        //TODO:Implement attack
    }
}
