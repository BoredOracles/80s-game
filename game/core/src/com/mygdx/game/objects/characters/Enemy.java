package com.mygdx.game.objects.characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.weapons.Weapon;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Enemy extends Character {
    int collisionDamage;

    public Enemy(Sprite sprite, Weapon weapon, float width, float height) {
        super(sprite, weapon, width, height);
    }


    @Override
    public void onCollide(Player player){
        player.decHealth(collisionDamage);
    }
}
