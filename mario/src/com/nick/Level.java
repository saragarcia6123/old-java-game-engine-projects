package com.nick;

import com.nick.GameObjects.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Level {

    private LinkedList<GameObject> entities;
    private Color backgroundColor;

    public Level(LinkedList<GameObject> entities, Color backgroundColor) {
        this.entities = entities;
        this.backgroundColor = backgroundColor;
    }

    public void tick() {
        for (GameObject e : entities) {
            e.tick();
        }
    }

    public void render(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(0,0,Constants.APP_WIDTH,Constants.APP_HEIGHT);
        for (GameObject e : entities) {
            e.render(g);
        }
    }

}
