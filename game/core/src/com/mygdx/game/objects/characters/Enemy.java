package com.mygdx.game.objects.characters;

import com.mygdx.game.util.SpriteSheet;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Enemy extends Character {
    int collisionDamage;

    public Enemy(SpriteSheet spriteSheet, float width, float height) {
        super(spriteSheet, width, height);
    }


    @Override
    public void onCollide(Player player){
        player.decHealth(collisionDamage);
    }
}
