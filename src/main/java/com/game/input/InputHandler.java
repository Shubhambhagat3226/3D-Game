package com.game.input;

import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, FocusListener {

    public boolean forward, back,
            left, right,
            turnLeft, turnRight;


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
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            forward = true;
        }
        if (code == KeyEvent.VK_S) {
            back = true;
        }
        if (code == KeyEvent.VK_A) {
            left = true;
        }
        if (code == KeyEvent.VK_D) {
            right = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            turnLeft = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            turnRight = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            forward = false;
        }
        if (code == KeyEvent.VK_S) {
            back = false;
        }
        if (code == KeyEvent.VK_A) {
            left = false;
        }
        if (code == KeyEvent.VK_D) {
            right = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            turnLeft = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            turnRight = false;
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
