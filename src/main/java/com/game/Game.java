package com.game;

import com.game.input.Controller;
import com.game.input.InputHandler;

import java.awt.event.KeyEvent;

public class Game {
    public int time;
    public Controller controller;

    public Game() {
        controller = new Controller();
    }

    public void tick(InputHandler input) {
        time++;;

        controller.tick(input);
    }
}
