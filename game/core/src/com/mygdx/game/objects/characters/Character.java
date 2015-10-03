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

    public Character(SpriteSheet spriteSheet, int health, float width, float height) {
        super(spriteSheet, width, height);
        this.health = health;
        this.spriteSheet = spriteSheet;
        this.dx = 0;
    }

    public void onDeath(){
        // Do nothing
    }

    public int getHealth(){
        return health;
    }

    private void checkDead(){
        if(health <= 0) onDeath();
    }

    public void incHealth(int healthDelta){
        health += healthDelta;
        checkDead();
    }

    public void decHealth(int healthDelta){
        incHealth(-healthDelta);
    }

    public void setHealth(int health){
        this.health = health;
        checkDead();
    }

    @Override
    public void draw(SpriteBatch batch){
        super.updateRect();
        batch.draw(spriteSheet.getCurrentFrame(), getX(), getY(), getWidth(), getHeight());
    }


}
