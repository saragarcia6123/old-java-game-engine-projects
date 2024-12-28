package com.nick;

import com.nick.GameObjects.GameObject;

public interface Observer {

    void onNotify(GameObject gameObject, Event event);

}
