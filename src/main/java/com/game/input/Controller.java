package com.game.input;

public class Controller {

    public double x, z, rotation, xa, za, rotationA;

    public void tick(InputHandler input) {

        double rotationSpeed = 0.025;
        double walkSpeed     = 1;
        double xMove         = 0;
        double zMove         = 0;

        if (input.forward) {
            zMove++;
        }
        if (input.back) {
            zMove--;
        }
        if (input.left) {
            xMove--;
        }
        if (input.right) {
            xMove++;
        }
        if (input.turnLeft) {
            rotationA -= rotationSpeed;
        }
        if (input.turnRight) {
            rotationA += rotationSpeed;
        }

        xa += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * walkSpeed;
        za += (zMove * Math.cos(rotation) - xMove * Math.sin(rotation)) * walkSpeed;

        x += xa;
        z += za;

        xa *= 0.1;
        za *= 0.1;
        rotation  += rotationA;
        rotationA *= 0.2;
    }
}
