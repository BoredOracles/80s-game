package com.mygdx.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.InfiniteScrollingScreen;
import com.mygdx.game.objects.weapons.Projectile;
import com.mygdx.game.util.SpriteSheet;

/**
 * Created by paul on 03/10/15.
 */
public class Player extends com.mygdx.game.objects.characters.Character {
    private static String TAG = Player.class.getSimpleName();

    private InfiniteScrollingScreen screen;
    private int score;
    public int speed;
    private Texture[] healthBars;
    Sound arrowSound = Gdx.audio.newSound(Gdx.files.internal("sound/Arrow.mp3"));
    private static Sound regainHP = Gdx.audio.newSound(Gdx.files.internal("sound/RegainHP.mp3"));
    private static Sound natas = Gdx.audio.newSound(Gdx.files.internal("sound/Natas Esiarp.mp3"));
    private int praised;

    public Player(SpriteSheet spriteSheet, int health, float width, float height, InfiniteScrollingScreen screen) {
        super(spriteSheet, health, width, height);
        this.screen = screen;
        this.score = 0;
        this.speed = 200;
        this.healthBars = new Texture[4];
        this.healthBars[0] = new Texture("HealthBar0.png");
        this.healthBars[1] = new Texture("HealthBar1.png");
        this.healthBars[2] = new Texture("HealthBar2.png");
        this.healthBars[3] = new Texture("HealthBar3.png");
        praised = 1000;
    }

    @Override
    public void onCollide(Player player) {
        // There's only one player, so this should never be called
        Gdx.app.error(TAG, "Player collided with self");
    }

    public void incScore(int deltaScore){
        this.score += deltaScore;
        if (score > praised) {
        natas.play(1.0f);
        praised *= 2;}
    }
    
    @Override
    public void incHealth(int healthDelta){
    	super.incHealth(healthDelta);
    	if (healthDelta>0) {regainHP.play(1.5f);}
    }
    
    public int getScore(){
    	return score;
    }

    @Override
    public void onDeath(){
        super.onDeath();
        screen.onPlayerDeath();
    }
    
    public Texture getHealthbar(){
        if(getHealth() > 0 && getHealth() <= 3){
            return healthBars[getHealth()];
        }
        return healthBars[0];
    }

    public Projectile fireArrow(){
        arrowSound.play(1.0f);
        Texture playerSheet = new Texture("Arrow.png");
        Sprite sheet = new Sprite(playerSheet);
        return new Projectile(sheet, 1, 1000, 32, 96);
    }

}
