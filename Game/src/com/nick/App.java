package com.nick;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class App implements Runnable {

    private Display display;

    private String title;
    private int width, height;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private State game, menu;

    private KeyAdapter ka;

    public App(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {

        FileHandler.createFolder("assets");

        display = new Display(title, width, height);

        game = new Game(width, height);
        menu = new Menu(width, height);
        State.setState(game);

        ka = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                State.getState().onKeyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                State.getState().onKeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                State.getState().onKeyReleased(e);
            }
        };

        display.getCanvas().addKeyListener(ka);
    }

    private void tick() {
        if(State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        g.clearRect(0,0, width, height);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        if(State.getState() != null) {
            State.getState().render(g);
        }

        bs.show();
        g.dispose();

    }

    public synchronized void start() {
        if(running)
            return;
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        init();
        double fps = 60;
        double delta = 0;
        double timePerTick = 1000000000/fps;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now-lastTime)/timePerTick;
            timer += now-lastTime;
            lastTime = now;
            if(delta >= 0) {
                tick();
                render();
                ticks++;
                delta--;
            }
            //Update the number of ticks every second to the frame title
            if(timer >= 1000000000) {
                timer = 0;
                ticks = 0;
            }
        }
        stop();
    }

}
