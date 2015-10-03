package com.mygdx.game.objects.characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.weapons.Projectile;

/**
 * Created by richy734 on 03/10/15.
 */
public class LaserRobot extends Enemy {

    public LaserRobot(Sprite sprite, float width, float height){
        super(sprite, new Projectile(sprite, 1), width, height);
    }

}
