package com.mygdx.game.objects.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.Collidable;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public class Projectile extends Collidable {
    private int damage;
    private int vX;


    public Projectile(Sprite sprite, int damage, float width, float height) {
        super(sprite, width, height);
        this.damage = damage;
    }

    @Override
    public void onCollide(Player player) {
        player.decHealth(damage);
    }

    public void attack() {
        //TODO:Implement attack
    }
}
