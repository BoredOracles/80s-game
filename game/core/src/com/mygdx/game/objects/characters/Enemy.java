package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Enemy extends Character {
	Sound sound = Gdx.audio.newSound(Gdx.files.internal("sound/grunt.mp3"));
    int collisionDamage;

    public Enemy(SpriteSheet spriteSheet, float width, float height) {
        super(spriteSheet, width, height);
    }


    @Override
    public void onCollide(Player player){
    	sound.play();
        player.decHealth(collisionDamage);
    }
}
