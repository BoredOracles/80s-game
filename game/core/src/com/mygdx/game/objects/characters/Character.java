package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.objects.Collidable;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Character extends Collidable {
    int health;

    public Character(Sprite sprite){
        super(sprite);
    }

    public void move(float x, float y){
        this.x += x * Gdx.graphics.getDeltaTime();
        this.y += y * Gdx.graphics.getDeltaTime();
    }

    public void moveTo(float x, float y){
        this.x = x * Gdx.graphics.getDeltaTime();
        this.y = y * Gdx.graphics.getDeltaTime();
    }

    public void attack(){
        //TODO: Implement
    }

    public int getHealth(){
        return health;
    }

    public void incHealth(int healthDelta){
        health += healthDelta;
    }

    public void setHealth(int health){
        this.health = health;
    }
}
