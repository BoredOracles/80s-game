package com.mygdx.game;

/**
 * Created by richy734 on 03/10/15.
 */
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.objects.characters.Player;

public class InfiniteBackgroundGame implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture background;
    private Texture backImage;

    private float secondBgY;
    private float currentBgY;
    private long lastTimeBg;

    private Player player;

    @Override
    public void create() {

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();

        background = new Texture("background.jpg");
        currentBgY = 480;
        secondBgY = 0;
        lastTimeBg = TimeUtils.nanoTime();

        backImage = new Texture("background.jpg");

        Texture playerTexture = new Texture("Orc1.png");
        Sprite playerSprite = new Sprite(playerTexture);
        player = new Player(playerSprite, 100, 100);
        player.moveTo(200, 200);
        Music music = Gdx.audio.newMusic(Gdx.files.internal("sound/Annulus.mp3"));
        music.setLooping(true);
        music.play();

    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, currentBgY - 480, 800, 480);
        batch.draw(background, 0, currentBgY, 800, 480);
        batch.draw(backImage, 0, secondBgY - 480, 800, 480);
        batch.draw(backImage, 0, secondBgY, 800, 480);
        player.draw(batch);
        batch.end();

        if(TimeUtils.nanoTime() - lastTimeBg > 50000000){
            currentBgY -= 30;
            secondBgY -= 30;
            lastTimeBg = TimeUtils.nanoTime();
        }

        if(currentBgY == 0){
            currentBgY = 480;
            secondBgY = 0;
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
}
