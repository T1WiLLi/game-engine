package doctrina.engine;

import java.awt.Graphics2D;

public abstract class Game {

    private static final int SLEEP = 25;
    private RenderingEngine renderingEngine;
    private long before;
    private boolean playing = true;

    protected abstract void init();

    protected abstract void update();

    protected abstract void drawOnBuffer(Graphics2D graphics2D);

    public Game() {
        renderingEngine = new RenderingEngine();
    }

    protected void start() {
        init();
        renderingEngine.start();
        updateSyncTime();

        while (playing) {
            update();
            drawOnBuffer(renderingEngine.buildBufferEngine());
            renderingEngine.drawBufferOnScreen();
            sleep();
        }
    }

    private void sleep() {
        long sleep = getSleep();

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateSyncTime();
    }

    private long getSleep() {
        long sleep = SLEEP - (System.currentTimeMillis() - before);
        if (sleep < 4) {
            sleep = 4;
        }
        return sleep;
    }

    private void updateSyncTime() {
        before = System.currentTimeMillis();
    }
}
