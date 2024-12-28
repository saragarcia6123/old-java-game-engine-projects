package com.nick;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage[] player;

    public static void init() {
        player = new BufferedImage[2];
        BufferedImage playerSpriteSheet = ImageLoader.loadImage("assets/player");

    }

}
