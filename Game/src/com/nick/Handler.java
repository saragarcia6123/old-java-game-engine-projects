package com.nick;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private LinkedList<Entity> entities = new LinkedList<>();

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(g);
        }
    }

}
