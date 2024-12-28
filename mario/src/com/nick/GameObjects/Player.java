package com.nick.GameObjects;

import java.awt.*;

public class Player extends GameObject {

    public static int lives = 5;

    public Player(ID id, int x, int y, int width, int height) {
        super(id, x, y, width, height, 0);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

}
