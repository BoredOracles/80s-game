package com.mygdx.game;

/**
 * Created by richy734 on 03/10/15.
 */
import com.badlogic.gdx.Game;

public class OrkGame extends Game {
    InfiniteScrollingScreen infiniteScrollingScreen;


    @Override
    public void create() {
        infiniteScrollingScreen = new InfiniteScrollingScreen(this);
        setScreen(infiniteScrollingScreen);
    }

}
