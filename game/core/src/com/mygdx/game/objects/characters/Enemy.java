package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by paul on 03/10/15.
 */
public abstract class Enemy extends Character {
	Sound grunt = Gdx.audio.newSound(Gdx.files.internal("sound/grunt.mp3"));
    Sound winDeath = Gdx.audio.newSound(Gdx.files.internal("sound/RobotDeath.mp3"));
	Sound playerDeath = Gdx.audio.newSound(Gdx.files.internal("sound/OrcDeath.mp3"));
    int collisionDamage;

    public Enemy(SpriteSheet spriteSheet, int health, float width, float height) {
        super(spriteSheet, health, width, height);
    }

    @Override
    public void onCollide(Player player){
        player.decHealth(collisionDamage);
        if (player.getHealth() <= 0){
        	playerDeath.play();
        	//TODO: game over screen
        }
    	grunt.play();
    }

    @Override
    public void decHealth(int i){
        winDeath.play();
    }
}
