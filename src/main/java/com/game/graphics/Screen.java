package com.game.graphics;

import com.game.Game;

import java.util.Random;

public class Screen extends Render {

    private Render test;
    private Render3D render3D;

    public Screen(int width, int height) {

        super(width, height);

        Random random = new Random();
        render3D = new Render3D(width, height);
        test = new Render(256, 256);
        for (int i = 0; i < 256 * 256; i++) {
            test.pixels[i] = random.nextInt() * (random.nextInt(5)/4);
        }
    }

    public void render(Game game) {
        for (int i = 0; i < width * height; i++) {
            pixels[i] = 0;
        }

        render3D.floor(game);
        render3D.renderDistanceLimiter();
        draw(render3D, 0, 0);

    }
}
