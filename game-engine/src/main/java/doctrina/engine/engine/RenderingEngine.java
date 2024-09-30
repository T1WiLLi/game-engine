package doctrina.engine.engine;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public final class RenderingEngine {

    private static RenderingEngine instance;

    private JFrame frame;
    private JPanel panel;
    private BufferedImage img;
    private Graphics2D bufferEngine;

    public static RenderingEngine getInstance() {
        if (instance == null) {
            instance = new RenderingEngine();
        }
        return instance;
    }

    public void start() {
        frame.setVisible(true);
    }

    public void stop() {
        frame.setVisible(false);
        frame.dispose();
    }

    public Canvas buildCanvas() {
        img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        bufferEngine = img.createGraphics();
        bufferEngine.setRenderingHints(getHints());
        return new Canvas(bufferEngine);
    }

    public void drawBufferOnScreen() {
        Graphics2D graphics2d = (Graphics2D) panel.getGraphics();
        graphics2d.drawImage(img, 0, 0, panel);
        Toolkit.getDefaultToolkit().sync();
        graphics2d.dispose();
    }

    public void addKeyListener(KeyListener keyListener) {
        panel.addKeyListener(keyListener);
    }

    private RenderingEngine() {
        initFrame();
        initPanel();
    }

    private RenderingHints getHints() {
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        return hints;
    }

    private void initFrame() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Game-engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setState(JFrame.NORMAL);
        frame.setUndecorated(true);
    }

    private void initPanel() {
        this.panel = new JPanel();
        this.panel.setBackground(Color.BLUE);
        this.panel.setFocusable(true);
        this.panel.setDoubleBuffered(true);
        frame.add(panel);
    }
}
