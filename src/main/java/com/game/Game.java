package com.game;

import com.game.input.Controller;

import java.awt.event.KeyEvent;

public class Game {
    public int time;
    public Controller controller;

    public Game() {
        controller = new Controller();
    }

    public void tick(boolean[] key) {
        time++;

        boolean forward   = key[KeyEvent.VK_W];
        boolean back      = key[KeyEvent.VK_S];
        boolean left      = key[KeyEvent.VK_A];
        boolean right     = key[KeyEvent.VK_D];
        boolean turnLeft  = key[KeyEvent.VK_LEFT];
        boolean turnRight = key[KeyEvent.VK_RIGHT];

        controller.tick(forward, back, left, right, turnLeft, turnRight);
    }
}
