package com.sara;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    char dir = 'l';
    int x = 100;
    int y = 100;
    int speed = 10;

    public Player(int width, int height) {
        super(width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void onKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                if (this.dir != 'r') {
                    x -= this.speed;
                }
                dir = 'l';
            }
            case KeyEvent.VK_RIGHT -> {
                if (dir != 'l') {
                    x += this.speed;
                }
                dir = 'r';

            }
            case KeyEvent.VK_UP -> {
                if (dir != 'd') {
                    y -= this.speed;
                }
                dir = 'u';
            }
            case KeyEvent.VK_DOWN -> {
                if (dir != 'u') {
                    y += this.speed;
                }
                dir = 'd';
            }
        }
    }

    public void onKeyReleased(KeyEvent e) {

    }

}