package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by paul on 03/10/15.
 */
public class Player extends com.mygdx.game.objects.characters.Character {
    private static String TAG = Player.class.getSimpleName();

    private int score;
    public int speed;
    

    public Player(SpriteSheet spriteSheet, float width, float height) {
        super(spriteSheet, width, height);
        this.score = 0;
        this.speed = 200;
    }

    @Override
    public void onCollide(Player player) {
        // There's only one player, so this should never be called
        Gdx.app.error(TAG, "Player collided with self");
    }

    public void incScore(int deltaScore){
        this.score += deltaScore;
    }
    
    public int getScore(){
    	return score;
    }

}
