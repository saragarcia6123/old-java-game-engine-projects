package com.nick;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class State {

    protected int width, height;

    public State(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void onKeyTyped(KeyEvent e);

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onKeyReleased(KeyEvent e);

}
