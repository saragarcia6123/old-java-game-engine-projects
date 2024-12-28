package com.nick;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {

    private int appWidth, appHeight;
    private GameLoop gameLoop;

    private LevelSelect levelSelect;
    private Level currentLevel;

    public Game(int appWidth, int appHeight, GameLoop gameLoop) {
        this.appWidth = appWidth;
        this.appHeight = appHeight;
        this.gameLoop = gameLoop;

        levelSelect = new LevelSelect();
    }

    public void onKeyPressed(KeyEvent e) {

    }

    public void tick() {

    }

    public void render(Graphics g) {
        if (currentLevel != null) {
            currentLevel.render(g);
        } else {

        }
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

}
