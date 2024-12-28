package com.nick.GameObjects;

import java.awt.*;

//things you can pick up
public class Collectable extends GameObject {

    public Collectable(ID id, int x, int y, int width, int height) {
        super(id, x, y, width, height,0);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
