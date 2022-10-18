package engine;

import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Kanishka
 */
public abstract class Canvas extends JFrame {

    private final int width;
    private final int height;
    private final int locX;
    private final int locY;
    private long startTime;
    private long nowTime;
    private final long secendsPerFrame;
    public Graphics g;
    private long fpsStartTime;
    private long fpsNowTime;
    private boolean setup = false;
    private int x = 0;
    private int y = 0;
    private int fps = 0;

    protected Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.secendsPerFrame = (1000 / 60);
        this.locX = 0;
        this.locY = 0;
        startTime = System.currentTimeMillis();
        this.fpsStartTime = System.currentTimeMillis();

        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    protected Canvas(int width, int height, int locX, int locY) {
        this.width = width;
        this.height = height;
        this.locX = locX;
        this.secendsPerFrame = (1000 / 60);

        this.locY = locY;
        this.setSize(width, height);
        this.startTime = System.currentTimeMillis();
        this.fpsStartTime = System.currentTimeMillis();

        this.setLocation(locX, locY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {

        this.g = g;
        fps++;
        if (!setup) {
            setup();
            setup=true;
        }
        drow();
        update();

    }

    public void clear(Graphics g) {
        super.paint(g);
    }

    

    public void drow() {
        new Thread(() -> {
            while (true) {

                nowTime = System.currentTimeMillis();
                fpsNowTime = System.currentTimeMillis();
                if ((fpsNowTime - fpsStartTime) >= 1000) {
                    fpsStartTime = fpsNowTime;

                    fps = 0;

                }

                long dif = nowTime - startTime;
                if (dif >= secendsPerFrame) {

                    repaint();

                    startTime = nowTime;

                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }).start();
    }

    public abstract void setup();

    public abstract void update();
}
