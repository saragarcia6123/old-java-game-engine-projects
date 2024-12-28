package com.nick;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private char dir = 'l';

    public Player(int width, int height) {
        super(width, height);
        x = 100;
        y = 100;

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
                if (dir != 'r') {
                    x--;
                }
                dir = 'l';
            }
            case KeyEvent.VK_RIGHT -> {
                if (dir != 'l') {
                    x++;
                }
                dir = 'r';

            }
            case KeyEvent.VK_UP -> {
                if (dir != 'd') {
                    y--;
                }
                dir = 'u';
            }
            case KeyEvent.VK_DOWN -> {
                if (dir != 'u') {
                    y++;
                }
                dir = 'd';

            }
        }
    }

    public void onKeyReleased(KeyEvent e) {

    }

    public void move () {

    }

}