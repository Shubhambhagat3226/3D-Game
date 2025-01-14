package com.game.graphics;

import com.game.Game;

public class Render3D extends Render{
    public double[] zBuffer;
    private double renderDistance = 5000;

    public Render3D(int width, int height) {
        super(width, height);
        zBuffer = new double[width * height];
    }

    public void floor(Game game) {

        double floorPosition   = 8;
        double ceilingPosition = 8;

        double forward = game.controller.z;
        double right   = game.controller.x;

        double rotation = game.controller.rotation;
        double cosine   = Math.cos(rotation);
        double sine     = Math.sin(rotation);

        for (int y = 0; y < height; y++) {
            double yDepth = (y - height / 2.0)/ height;
            double z      = floorPosition / yDepth;

            if (yDepth < 0) {
                z = ceilingPosition / -yDepth;
            }
            for (int x = 0; x < width; x++) {
                double depth = (x - width / 2.0)/ width;
                depth *= z;

                double xx = depth * cosine + z * sine + right;
                double yy = z * cosine - depth * sine + forward;
                int xPix = (int) xx;
                int yPix = (int) yy;
                zBuffer[x + y * width] = z;
                pixels[x + y * width] = ((xPix & 15) * 16) | ((yPix & 15)* 16) << 8;

                if (z > 500) {
                    pixels[x + y * width] = 0;
                }
            }
        }
    }

    public void renderDistanceLimiter() {
        for (int i = 0; i < width * height; i++) {
            int color = pixels[i];
            int brightness = (int) (renderDistance / zBuffer[i]);

            if (brightness < 0) {
                brightness = 0;
            }
            if (brightness > 255) {
                brightness = 255;
            }

            int r = (color >> 16) & 0xff;
            int g = (color >> 8) & 0xff;
            int b = (color) & 0xff;

            r = (r * brightness /255);
            g = (g * brightness /255);
            b = (b * brightness /255);

            pixels[i] = r << 16 | g << 8 | b;
        }
    }

    private int getPix(double pos, double movement) {
        return (int) (pos + movement);
    }
}
