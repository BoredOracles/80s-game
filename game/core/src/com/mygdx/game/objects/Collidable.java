package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Collidable extends Actor {
    Rectangle rect;
    Sprite sprite;

    public Collidable(Sprite sprite, float width, float height){
        this.sprite = sprite;
        setWidth(width);
        setHeight(height);
        rect = new Rectangle();
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
        updateRect();
        batch.draw(sprite, getX(), getY(), getWidth(), getHeight());
    }

    protected void updateRect(){
        rect.set(getX(), getY(), getWidth(), getHeight());
    }

    public Rectangle getRect(){
        return rect;
    }

    public boolean collidingWith(Player player){
        return Intersector.overlaps(rect, player.getRect());
    }
}
