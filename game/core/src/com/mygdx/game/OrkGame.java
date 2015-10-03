package com.mygdx.game;

/**
 * Created by richy734 on 03/10/15.
 */
import com.badlogic.gdx.Game;

public class OrkGame extends Game {
    public MainMenuScreen menuScreen;
    public InfiniteScrollingScreen infiniteScrollingScreen;

    @Override
    public void create() {
        menuScreen = new MainMenuScreen(this);
        infiniteScrollingScreen = new InfiniteScrollingScreen(this);
        setScreen(menuScreen);
    }

}
