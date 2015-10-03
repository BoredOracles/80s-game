package com.mygdx.game;

/**
 * Created by richy734 on 03/10/15.
 */
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
import com.mygdx.game.objects.characters.Player;
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

    private Projectile car;
    
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




        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Texture playerSheet = new Texture("OrcSpritesheet.png");
        SpriteSheet sheet = new SpriteSheet(playerSheet, 1, 2, 0.3f);
        player = new Player(sheet, playerSize, playerSize);
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
                return true;
            }
        });

        Music music = Gdx.audio.newMusic(Gdx.files.internal("sound/Annulus.mp3"));
        music.setLooping(true);
        music.play();
        
        car = spawnCar();
        stage.addActor(car);
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
        
        player.draw(batch);
        
        font.draw(batch, Integer.toString(player.getScore()), 16, screenHeight - 16);
        car.draw(batch);
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
    	Projectile car = new Projectile(carSprite, 3, -1000, carSize, carSize);
    	return car;
    }
}
