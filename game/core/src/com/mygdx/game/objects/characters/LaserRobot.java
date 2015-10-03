package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.objects.weapons.Projectile;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by richy734 on 03/10/15.
 */
public class LaserRobot extends Enemy {


    private long sinceLastLaser = 500;
    private static Texture laserText = new Texture("Laser.png");
    private static Sprite laserSprite = new Sprite(laserText);
    private static Projectile laser;
    Sound lazerShot = Gdx.audio.newSound(Gdx.files.internal("sound/GunEffect.mp3"));
    public LaserRobot(SpriteSheet spriteSheet, int health, float width, float height){
        super(spriteSheet, health, width, height);
    }

    public long getSinceLastLaser(){
        return sinceLastLaser;
    }

    public Projectile fireLaser(){
        lazerShot.play();
        sinceLastLaser = TimeUtils.millis();
        return new Projectile(laserSprite, 1, -1000, 32, 32);
    }

}
