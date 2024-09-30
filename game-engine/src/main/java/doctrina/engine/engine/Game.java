package doctrina.engine.engine;

import java.awt.event.KeyListener;

public abstract class Game {

    private final RenderingEngine renderingEngine;
    private boolean playing = true;

    protected abstract void init();

    protected abstract void update();

    protected abstract void render(Canvas canvas);

    protected abstract void conclude();

    public Game() {
        renderingEngine = RenderingEngine.getInstance();
    }

    public final void start() {
        init();
        run();
        conclude();
    }

    public final void stop() {
        playing = false;
    }

    public void addKeyListener(KeyListener keyListener) {
        renderingEngine.addKeyListener(keyListener);
    }

    private void run() {
        renderingEngine.start();
        GameTime.getInstance();
        while (playing) {
            update();
            render(renderingEngine.buildCanvas());
            renderingEngine.drawBufferOnScreen();
            GameTime.getInstance().sync();
        }
        renderingEngine.stop();
    }
}
