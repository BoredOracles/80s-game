package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by paul on 03/10/15.
 */
public class MenuScreen implements Screen {
    private SpriteBatch batch;
    private Texture background;
    private OrthographicCamera camera;
    private int screenWidth;
    private int screenHeight;

    private OrkGame game;

    public MenuScreen(OrkGame game, Texture background){
        this.game = game;
        this.background = background;
    }

    @Override
    public void show() {
        screenWidth = 1200;
        screenHeight = 1000;

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, screenWidth, screenHeight);

        batch.end();

        if(Gdx.input.isKeyJustPressed(Input.Keys.Y)){
            game.setScreen(game.infiniteScrollingScreen);
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }

    public OrkGame getGame(){
        return game;
    }
}
