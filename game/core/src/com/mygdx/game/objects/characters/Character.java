package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
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
    public int dx;

    public Character(SpriteSheet spriteSheet, float width, float height) {
        super(spriteSheet);
        this.spriteSheet = spriteSheet;
        this.width = width;
        this.height = height;
        this.dx = 0;
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
        batch.draw(spriteSheet.getCurrentFrame(), getX(), getY(), width, height);
    }
}
