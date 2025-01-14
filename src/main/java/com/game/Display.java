package com.game;

import com.game.graphics.Render;
import com.game.graphics.Screen;
import com.game.input.InputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Display extends Canvas implements Runnable {

    public static final long SERIAL_VERSION_UID = 1;
    public static final int WIDTH    = 800;
    public static final int HEIGHT   = 600;
    public static final double FPS   = 60;
    public static final String TITLE = "3D Game 0.02";

    private Thread thread;
    private boolean running = false;
    private Game game;
    private Screen screen;
    private BufferedImage img;
    private int[] pixels;

    private InputHandler input;


    public Display(){
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        screen = new Screen(WIDTH, HEIGHT);
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
        game = new Game();

        input = new InputHandler();
        addKeyListener(input);
        addFocusListener(input);
        addMouseListener(input);
        addMouseMotionListener(input);
    }
    // START
    private void start() {
        if (running) return;

        running = true;
        thread  = new Thread(this);
        thread.start();
    }
    // STOP
    private void stop() {
        if (!running) return;

        running = true;
        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    // DELTA LOOP
//    @Override
//    public void run() {
//        double drawIntervals = (double) 1000000000 / FPS; // 0.0166's
//        double delta = 0;
//        long lastTime = System.nanoTime();
//        long currentTime;
//
//        int frames = 0;
//        long timer = System.currentTimeMillis();
//        while (running) {
//
//            currentTime = System.nanoTime();
//            delta += (currentTime - lastTime) / drawIntervals;
//            lastTime = currentTime;
//
//            if (delta >= 1) {
//                // UPDATE INFORMATION SUCH AS CHARACTER POSITION
//                tick();
//
//                render();
//                frames++;
//
//                delta--;
//            }
//            // Print FPS every second
//            if (System.currentTimeMillis() - timer >= 1000) {
//                timer = System.currentTimeMillis();
//                System.out.println("FPS: " + frames);
//                frames = 0;
//            }
//
//        }
//    }
    @Override
    public void run() {
        int frame = 0;
        double unprocessedSecond = 0;
        long previousTime     = System.nanoTime();
        double secondsPerTick = 1 / FPS;
        int tickCount         = 0;
        boolean ticked        = false;
        while (running) {

            long currentTime = System.nanoTime();
            long passedTime  = currentTime - previousTime;
            previousTime     = currentTime;

            unprocessedSecond += passedTime/1000000000.0;

            while (unprocessedSecond > secondsPerTick) {
                tick();
                unprocessedSecond -= secondsPerTick;
                ticked = true;
                tickCount++;
                if (tickCount % FPS == 0) {
                    System.out.println(frame + "FPS");
                    previousTime += 1000;
                    frame = 0;
                }
            }
            if (ticked) {

                render();
                frame++;
            }
            render();
            frame++;
        }

    }
    private void tick() {

        game.tick(input);
    }
    private void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.render(game);
        for (int i = 0; i < WIDTH * HEIGHT; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        bs.show();

    }

    public static void main(String[] args) {

        Display game = new Display();
        JFrame frame = new JFrame(TITLE);

        frame.add(game);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }


}
