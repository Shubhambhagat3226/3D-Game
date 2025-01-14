package com.game.input;

import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, FocusListener {

    public boolean[] key = new boolean[68836];


    // FOCUS-LISTER STUFF
    @Override
    public void focusGained(FocusEvent e) {

    }
    @Override
    public void focusLost(FocusEvent e) {

    }


    // KEY-LISTENER STUFF
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode > 0 && keyCode < key.length) {
            key[keyCode] = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode > 0 && keyCode < key.length) {
            key[keyCode] = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}


    // MOUSE-LISTENER STUFF
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    // MOUSE-MOTION STUFF
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
