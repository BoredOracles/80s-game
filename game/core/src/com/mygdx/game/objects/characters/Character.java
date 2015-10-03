package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Collidable;
import com.mygdx.game.objects.weapons.Weapon;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Character extends Collidable {
    int health;
    Weapon weapon;
    public float width;
    public float height;

    public Character(Sprite sprite, Weapon weapon, float width, float height){
        super(sprite);
        this.weapon = weapon;
        this.width = width;
        this.height = height;
    }

    public Character(Sprite sprite, float width, float height){
        this(sprite, null, width, height);
    }

    public void move(float x, float y){
        this.x += x * Gdx.graphics.getDeltaTime();
        this.y += y * Gdx.graphics.getDeltaTime();
    }

    public void moveTo(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void attack(){
        if(weapon != null) weapon.attack();
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

    public void draw(SpriteBatch batch){
        batch.draw(getSprite(), x, y, width, height);
    }
}
