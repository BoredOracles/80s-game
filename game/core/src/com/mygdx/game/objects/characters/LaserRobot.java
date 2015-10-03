package com.mygdx.game.objects.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.weapons.Projectile;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by richy734 on 03/10/15.
 */
public class LaserRobot extends Enemy {

    private static Texture laser = new Texture("Laser.png");
    private static Sprite sprite = new Sprite(laser);

    public LaserRobot(SpriteSheet spriteSheet, float width, float height){
        super(spriteSheet, width, height);
    }

}
