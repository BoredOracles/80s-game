package com.mygdx.game.objects.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Collidable;
import com.mygdx.game.objects.characters.Enemy;
import com.mygdx.game.objects.characters.Player;

/**
 * Created by paul on 03/10/15.
 */
public class Projectile extends Collidable {
    private int damage;
    private float vY;

	private static Sound grunt = Gdx.audio.newSound(Gdx.files.internal("sound/grunt.mp3"));

	private static Sound playerDeath = Gdx.audio.newSound(Gdx.files.internal("sound/OrcDeath.mp3"));
    
    public Projectile(Sprite sprite, int damage, float speed, float width, float height) {
        super(sprite, width, height);
        this.damage = damage;
        vY = speed;
    }

    public void moveToOverTime(){
        setY(getY() + Gdx.graphics.getDeltaTime() * vY);
    }

    @Override
    public void onCollide(Player player) {
        player.decHealth(damage);
        if (player.getHealth() <= 0){
        	playerDeath.play(1.5f);
        	//TODO: game over screen
        } else {
    	grunt.play(1.5f); }
    }

    public void onCollideRobot(Enemy robot) {
        robot.decHealth(damage);
    }

    @Override
    public void draw(SpriteBatch batch){
        super.draw(batch);
        moveToOverTime();
    }


}
