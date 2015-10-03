package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Collidable;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Character extends Collidable {
    private int health;
    public float width;
    public float height;
    public SpriteSheet spriteSheet;

    public Character(SpriteSheet spriteSheet, float width, float height) {
        super(spriteSheet);
        this.spriteSheet = spriteSheet;
        //this.weapon = weapon;
        this.width = width;
        this.height = height;
    }


    public void move(float x, float y){
        this.x += x * Gdx.graphics.getDeltaTime();
        this.y += y * Gdx.graphics.getDeltaTime();
    }

    public void moveTo(float x, float y){
        this.x = x;
        this.y = y;
    }

    private boolean hasWeapon(){
        //return weapon != null;
    }

    public void attack(){
        //if(hasWeapon()) weapon.attack();
    }

    public int getHealth(){
        return health;
    }

    public void incHealth(int healthDelta){
        health += healthDelta;
    }

    public void decHealth(int healthDelta){
        incHealth(-healthDelta);
    }

    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(spriteSheet.getCurrentFrame(), x, y, width, height);
    }
}
