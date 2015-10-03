package com.mygdx.game.objects.characters;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by richy734 on 03/10/15.
 */
public class SwordRobot extends Enemy {

	private Sound [] sounds;
	private Random random;
	
    public SwordRobot(SpriteSheet spriteSheet, float width, float height){
        super(spriteSheet, width, height);
        sounds = new Sound[3];
        sounds[0] = Gdx.audio.newSound(Gdx.files.internal("sound/sword.mp3"));
        sounds[1] = Gdx.audio.newSound(Gdx.files.internal("sound/sword2.mp3"));
        sounds[2] = Gdx.audio.newSound(Gdx.files.internal("sound/sword3.mp3"));
        random = new java.util.Random();
    }
    
    @Override
    public void onCollide(Player player){
    	int index = random.nextInt(3);
    	sounds[index].play();
    	
    	super.onCollide(player);
    }

}
