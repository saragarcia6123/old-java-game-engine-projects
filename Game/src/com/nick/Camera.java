package com.nick;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Camera extends Entity {


    public Camera(int width, int height) {
        super(width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    public void onKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                x--;
            }
            case KeyEvent.VK_RIGHT: {
                x++;
            }
        }
    }

}
