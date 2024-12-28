package com.nick;

import java.awt.*;

public abstract class Entity {

    protected int x, y, width, height;

    public Entity(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

}
