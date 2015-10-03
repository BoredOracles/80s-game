package com.mygdx.game;

/**
 * Created by richy734 on 03/10/15.
 */
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.objects.characters.Enemy;
import com.mygdx.game.objects.characters.LaserRobot;
import com.mygdx.game.objects.characters.Player;
import com.mygdx.game.objects.characters.SwordRobot;
import com.mygdx.game.objects.pickups.Plutonium;
import com.mygdx.game.objects.weapons.Projectile;
import com.mygdx.game.util.SpriteSheet;

public class InfiniteBackgroundGame implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture background;
    private Texture backImage;


    private float secondBgY;
    private float currentBgY;
    private long lastTimeBg;
    private int deltaBg;

    private static float stateTime;

    private Stage stage;
    private Player player;
    
    private int screenWidth;
    private int screenHeight;
    private int playerSize;
    
    private BitmapFont font;
    private int carSize;

    private long sinceLastArrow = TimeUtils.millis();
    private Projectile car;
    private Plutonium plutonium;
    private SwordRobot swordRobot;
    private LaserRobot laserRobot;
    
    private ArrayList<Projectile> projectiles;
    private ArrayList<Enemy> enemies;
    
    @Override
    public void create() {
        screenWidth = 1200;
        screenHeight = 1000;
        playerSize = 100;
        carSize = 200;
        
        font = new BitmapFont();
        
        font.getData().setScale(4f,4f);
        
        font.setColor(Color.GREEN);
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);
        batch = new SpriteBatch();

        background = new Texture("background.jpg");

        currentBgY = screenHeight;
        secondBgY = 0;
        deltaBg = 15;
        lastTimeBg = TimeUtils.nanoTime();

        backImage = new Texture("background.jpg");


        projectiles = new ArrayList<Projectile>();
        enemies = new ArrayList<Enemy>();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Texture robotText = new Texture("EyeRobotSpritesheet.png");
        SpriteSheet robotSheet = new SpriteSheet(robotText, 1, 2, 0.3f);
        enemies.add(new LaserRobot(robotSheet, 1, playerSize, playerSize));
        enemies.get(0).moveTo(350, 900);

        Texture playerSheet = new Texture("OrcSpritesheet.png");
        SpriteSheet sheet = new SpriteSheet(playerSheet, 1, 2, 0.3f);
        player = new Player(sheet, 3, playerSize, playerSize);
        stage.addActor(player);
        stage.setKeyboardFocus(player);
        player.moveTo(350, 50);

        player.addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keyCode) {
                if ((keyCode == Input.Keys.RIGHT || keyCode == Input.Keys.D) && player.dx > 0) {
                    player.dx = 0;
                } else if ((keyCode == Input.Keys.LEFT || keyCode == Input.Keys.A) && player.dx < 0) {
                    player.dx = 0;
                }
                return true;
            }
        });
        player.addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keyCode) {
                if(keyCode == Input.Keys.RIGHT || keyCode == Input.Keys.D){
                    player.dx = player.speed;
                }
                else if(keyCode == Input.Keys.LEFT || keyCode == Input.Keys.A){
                    player.dx = -player.speed;
                }
                else if((keyCode == Input.Keys.SPACE) && (TimeUtils.millis() - sinceLastArrow > 500)){
                    sinceLastArrow = TimeUtils.millis();
                    Projectile arrow;
                    arrow = player.fireArrow();
                    arrow.moveTo(player.getX()+ 32, player.getY() + 128);
                    projectiles.add(arrow);

                }
                return true;
            }
        });

        Music music = Gdx.audio.newMusic(Gdx.files.internal("sound/Annulus.mp3"));
        music.setLooping(true);
        music.play();
        
        car = spawnCar();
        SwordRobot robot = spawnSwordRobot();
        stage.addActor(robot);
        enemies.add(robot);
        stage.addActor(car);
        projectiles.add(car);
    	car.moveTo(500, 400);
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        stage.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stateTime += Gdx.graphics.getDeltaTime();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, currentBgY - screenHeight, screenWidth, screenHeight);
        batch.draw(background, 0, currentBgY, screenWidth, screenHeight);
        batch.draw(backImage, 0, secondBgY - screenHeight, screenWidth, screenHeight);
        batch.draw(backImage, 0, secondBgY, screenWidth, screenHeight);
        batch.draw(player.getHealthbar(), screenWidth - 272, screenHeight- 80, 272, 80);
        player.move(player.dx, 0);
        if (player.getX() <= 0 || player.getX() >= screenWidth-playerSize){
        	player.move(-player.dx, 0);
        }

        for(Enemy enemy: enemies){
            enemy.draw(batch);
        }

        player.draw(batch);
        
        font.draw(batch, Integer.toString(player.getScore()), 16, screenHeight - 16);

        ArrayList<Integer> toDestroy = new ArrayList<Integer>();
        ArrayList<Integer> toDestroyRobot = new ArrayList<Integer>();
        for (Projectile proj : projectiles){
            proj.draw(batch);

            if(proj.collidingWith(player)) {
                proj.onCollide(player);
            }

            for(Enemy robot: enemies){
                if(proj.collidingWithRobot(robot)){
                    robot.decHealth(1);
                    toDestroyRobot.add(enemies.indexOf(robot));
                    toDestroy.add(projectiles.indexOf(proj));
                    player.incScore(3);
                }
            }

        	if (proj.getY() < -100) toDestroy.add(projectiles.indexOf(proj));

        }

        for (Integer i : toDestroy){
        	projectiles.remove(i.intValue());
        }

        for (Integer i : toDestroyRobot){
            enemies.remove(i.intValue());
        }
        
        
        batch.end();

        if(TimeUtils.nanoTime() - lastTimeBg > 50000000){
            currentBgY -= deltaBg;
            secondBgY -= deltaBg;
            lastTimeBg = TimeUtils.nanoTime();
        }

        if(currentBgY <= 0){
            currentBgY = screenHeight;
            secondBgY = 0;
            player.incScore(5);
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    public static float getStateTime(){
        return stateTime;
    }
    
    private Projectile spawnCar(){
    	Texture carTexture = new Texture("Delorean.png");
    	Sprite carSprite = new Sprite(carTexture);
    	Projectile car = new Projectile(carSprite, 3, -100, carSize, carSize);
    	return car;
    }
    
    private Plutonium spawnPlutonium(){
    	Texture plutoniumTexture = new Texture("Plutonium.png");
    	Sprite plutoniumSprite = new Sprite(plutoniumTexture);
    	Plutonium plutonium = new Plutonium(plutoniumSprite, playerSize, playerSize);
    	return plutonium;
    }
    
    private SwordRobot spawnSwordRobot(){
    	Texture sRobotSheet = new Texture("SwordRobotSpritesheet.png");
    	SpriteSheet sRobotSprite = new SpriteSheet(sRobotSheet, 2, 2, 0.12f);
    	SwordRobot swordRobot = new SwordRobot(sRobotSprite, 1, playerSize, playerSize);
    	return swordRobot;
    }
    
    private LaserRobot spawnLaserRobot(){
    	Texture lRobotSheet = new Texture("EyeRobotSpritesheet.png");
    	SpriteSheet lRobotSprite = new SpriteSheet(lRobotSheet, 1, 2, 0.3f);
    	LaserRobot laserRobot = new LaserRobot(lRobotSprite, 1, playerSize, playerSize);
    	return laserRobot;
    }
}