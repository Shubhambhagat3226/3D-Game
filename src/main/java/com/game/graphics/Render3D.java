package com.game.graphics;

import com.game.Game;

public class Render3D extends Render{

    public Render3D(int width, int height) {
        super(width, height);
    }

    public void floor(Game game) {
        for (int y = 0; y < height; y++) {
            double yDepth = (y - height / 2.0)/ height;
            if (yDepth < 0) {
                yDepth = -yDepth;
            }
            double z      = 8.0 / yDepth;

            for (int x = 0; x < width; x++) {
                double depth = (x - width / 2.0)/ width;
                depth *= z;

                int xPix = getPix(depth, 0);
                int yPix = getPix(z, game.time);
                pixels[x + y * width] = ((xPix & 15) * 16) | ((yPix & 15)* 16) << 8;

            }
        }
    }

    private int getPix(double pos, double movement) {
        return (int) (pos + movement);
    }
}
