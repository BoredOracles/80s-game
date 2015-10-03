package com.mygdx.game;

/**
 * Created by richy734 on 03/10/15.
 */
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;

public class OrkGame extends Game {
    public MenuScreen menuScreen;
    public MenuScreen endScreen;
    public InfiniteScrollingScreen infiniteScrollingScreen;

    @Override
    public void create() {
        menuScreen = new MenuScreen(this, new Texture("start screen.jpg"));
        endScreen = new MenuScreen(this, new Texture("Game Over.jpg"));
        infiniteScrollingScreen = new InfiniteScrollingScreen(this);
        setScreen(menuScreen);
    }

}
