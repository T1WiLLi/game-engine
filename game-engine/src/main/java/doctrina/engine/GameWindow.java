package doctrina.engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {

    private static final int SLEEP = 25;
    private boolean playing = true;
    private BufferedImage img;
    private Graphics2D bufferEngine;
    private long before;
    private int score = 0;

    private JPanel panel;

    private Ball ball = new Ball(25);

    public GameWindow() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Game-engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setState(JFrame.NORMAL);

        this.panel = new JPanel();
        this.panel.setBackground(Color.BLUE);
        this.panel.setFocusable(true);
        this.panel.setDoubleBuffered(true);

        add(panel);
    }

    public void start() {
        setVisible(true);

        before = System.currentTimeMillis();

        while (playing) {
            img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            bufferEngine = img.createGraphics();
            bufferEngine.setRenderingHints(hints);

            update();
            drawOnBuffer();
            drawBufferOnScreen();

            try {
                sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sleep() throws InterruptedException {
        long sleep = SLEEP - (System.currentTimeMillis() - before);
        if (sleep < 4) {
            sleep = 4;
        }
        Thread.sleep(sleep);
        before = System.currentTimeMillis();
    }

    private void drawBufferOnScreen() {
        Graphics2D graphics2d = (Graphics2D) panel.getGraphics();
        graphics2d.drawImage(img, 0, 0, panel);
        Toolkit.getDefaultToolkit().sync();
        graphics2d.dispose();
    }

    private void drawOnBuffer() {
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
}
