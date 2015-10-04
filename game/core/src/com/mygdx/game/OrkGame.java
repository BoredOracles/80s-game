package com.mygdx.game;

/**
 * Created by richy734 on 03/10/15.
 */
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;

import java.io.*;

public class OrkGame extends Game {
    private boolean highScoreLoaded = false;
    private int highScore = 0;

    private int currentScore;

    public MenuScreen menuScreen;
    public MenuScreen endScreen;
    public InfiniteScrollingScreen infiniteScrollingScreen;

    @Override
    public void create() {
        menuScreen = new MenuScreen(this, new Texture("start screen.jpg"));
        endScreen = new EndMenuScreen(this, new Texture("Game Over.jpg"));
        infiniteScrollingScreen = new InfiniteScrollingScreen(this);
        setScreen(menuScreen);
    }

    public void setCurrentScore(int score){
        currentScore = score;
    }

    public int getCurrentScore(){
        return currentScore;
    }

    public boolean saveScore(int score){
        if(score <= highScore) {
            return false;
        }

        highScore = score;

        try {
            String fileName = "highScore.ser";

            File saveFile = new File(fileName);
            if (saveFile.exists()){
                saveFile.delete();
            }

            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(score);
            out.close();
            fileOut.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return true;

    }

    public int getHighScore(){
        if(highScoreLoaded){
            return highScore;
        }

        try {
            FileInputStream fileIn = new FileInputStream("highScore.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            highScore = (Integer) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i) {
            i.printStackTrace();
        }
        catch(ClassNotFoundException c) {
            System.out.println("Score not found");
            c.printStackTrace();
        }

        highScoreLoaded = true;

        return highScore;

    }

}
