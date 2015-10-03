package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by paul on 03/10/15.
 */
public class Player extends com.mygdx.game.objects.characters.Character {
    private static String TAG = Player.class.getSimpleName();

    private int score;
    public int speed;
    private Texture[] healthBars;
    

    public Player(SpriteSheet spriteSheet, float width, float height) {
        super(spriteSheet, width, height);
        this.setHealth(3);
        this.score = 0;
        this.speed = 200;
        this.healthBars = new Texture[4];
        this.healthBars[0] = new Texture("HealthBar0.png");
        this.healthBars[1] = new Texture("HealthBar1.png");
        this.healthBars[2] = new Texture("HealthBar2.png");
        this.healthBars[3] = new Texture("HealthBar3.png");
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
    
    public Texture getHealthbar(){
        if(getHealth() > 0 && getHealth() <= 3){
            return healthBars[getHealth()];
        }
        return healthBars[0];
    }

}
