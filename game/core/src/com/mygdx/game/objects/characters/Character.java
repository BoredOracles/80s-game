package com.mygdx.game.objects.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Collidable;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Character extends Collidable {
    private int health;
    public SpriteSheet spriteSheet;
    public int dx;

    public Character(SpriteSheet spriteSheet, float width, float height) {
        super(spriteSheet, width, height);
        this.spriteSheet = spriteSheet;
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
        batch.draw(spriteSheet.getCurrentFrame(), getX(), getY(), getWidth(), getHeight());
    }


}
