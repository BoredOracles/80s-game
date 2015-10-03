package com.mygdx.game.objects.characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.weapons.Sword;
import com.mygdx.game.objects.weapons.Weapon;

/**
 * Created by richy734 on 03/10/15.
 */
public class SwordRobot extends Enemy {

    public SwordRobot(Sprite sprite, float width, float height){
        super(sprite, new Sword(sprite, 1), width, height);
    }

}
