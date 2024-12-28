package com.nick;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Game extends State {

    private Player player;

    public Game(int width, int height) {
        super(width, height);
        player = new Player(40, 80);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(120,150,250));
        g.fillRect(0,0, width, height);

        player.render(g);
    }

    @Override
    public void onKeyTyped(KeyEvent e) {

    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        player.onKeyPressed(e);
    }

    @Override
    public void onKeyReleased(KeyEvent e) {
        player.onKeyReleased(e);
    }

}
