package doctrina.engine;

import java.awt.Color;
import java.awt.Graphics2D;

public class Game {

    private static final int SLEEP = 25;

    private long before;
    private boolean playing = true;
    private RenderingEngine renderingEngine;
    private int score = 0;
    private Ball ball;

    public Game() {
        renderingEngine = new RenderingEngine();
        ball = new Ball(25);
    }

    public void start() {
        renderingEngine.start();
        updateSyncTime();

        while (playing) {
            update();
            drawOnBuffer(renderingEngine.buildBufferEngine());
            renderingEngine.drawBufferOnScreen();
            sleep();
        }
    }

    private void drawOnBuffer(Graphics2D bufferEngine) {
        ball.draw(bufferEngine);

        bufferEngine.setPaint(Color.WHITE);
        bufferEngine.drawString("Score: " + score, ball.getX() - 15, ball.getY() - 15);
    }

    private void update() {
        ball.update();
        if (ball.hasTouched()) {
            score += 10;
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
