package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Collidable extends Actor {
    Sprite sprite;

    public Collidable(Sprite sprite){
        this.sprite = sprite;
    }

    public Sprite getSprite(){
        return sprite;
    }

    public abstract void onCollide(Player player);

    public void move(float x, float y){
        setX(getX() + x * Gdx.graphics.getDeltaTime());
        setY(getY() + y * Gdx.graphics.getDeltaTime());
    }

    public void moveTo(float x, float y){
        setX(x);
        setY(y);
    }

    public void draw(SpriteBatch batch){
        batch.draw(sprite, getX(), getY(), getWidth(), getHeight());
    }
}
