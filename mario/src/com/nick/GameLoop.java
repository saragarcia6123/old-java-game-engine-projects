package com.nick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

public class GameLoop extends Canvas implements Runnable {

    private JFrame frame;

    private Thread thread;
    private boolean running = false;

    private Game game;

    private int mouseX = 0;
    private int mouseY = 0;

    private KeyAdapter KA;

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public GameLoop() {
        thread = new Thread(this);

        KA = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                game.onKeyPressed(e);
            }
        };
    }

    public void init() {

        //Initialise a new simulator
        game = new Game(Constants.APP_WIDTH, Constants.APP_HEIGHT, this);

        //Set the canvas properties
        setMaximumSize(new Dimension(Constants.APP_WIDTH, Constants.APP_HEIGHT));
        setMinimumSize(new Dimension(Constants.APP_WIDTH, Constants.APP_HEIGHT));
        setPreferredSize(new Dimension(Constants.APP_WIDTH, Constants.APP_HEIGHT));
        setBackground(Color.BLACK);

        //Set the frame properties
        frame = new JFrame("Interior Designer");
        this.addKeyListener(KA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public synchronized void start() {
        if(running) {
            return;
        }
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        if(!running) {
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        running = false;
    }

    public void tick() {
        game.tick();
    }

    public void render() {

        BufferStrategy bs = getBufferStrategy();

        if(bs == null) {
            createBufferStrategy(3);
            bs = getBufferStrategy();
        }

        Graphics g = bs.getDrawGraphics();

        //Clear the screen ready to redraw the next frame
        g.clearRect(0,0, Constants.APP_WIDTH, Constants.APP_HEIGHT);

        //Paints background
        super.paint(g);

        //Render everything in simulator to the screen
        game.render(g);

        bs.show();
        g.dispose();

    }

    @Override
    public void run() {

        init();

        //game loop

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
                frame.setTitle("Interior Designer (FPS: " + ticks + ")");
                timer = 0;
                ticks = 0;
            }

        }

        stop();

    }
}
