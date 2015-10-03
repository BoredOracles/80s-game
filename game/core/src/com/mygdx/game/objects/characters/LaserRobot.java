package com.mygdx.game.objects.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.weapons.Projectile;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by richy734 on 03/10/15.
 */
public class LaserRobot extends Enemy {


    private static Texture laserText = new Texture("Laser.png");
    private static Sprite laserSprite = new Sprite(laserText);
    private static Projectile laser;

    public LaserRobot(SpriteSheet spriteSheet, float width, float height){
        super(spriteSheet, width, height);
    }

    public Projectile fireLaser(){
        Texture playerSheet = new Texture("Laser.png");
        Sprite sheet = new Sprite(playerSheet);
        return new Projectile(sheet, 1, -1000, 32, 32);
    }

}
