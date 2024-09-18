package doctrina.engine.engine;

public abstract class Game {

    private RenderingEngine renderingEngine;
    private boolean playing = true;

    protected abstract void init();

    protected abstract void update();

    protected abstract void render(Canvas canvas);

    public Game() {
        renderingEngine = new RenderingEngine();
    }

    public final void start() {
        init();
        run();
    }

    private void run() {
        renderingEngine.start();
        GameTime.getInstance();
        while (playing) {
            update();
            render(renderingEngine.buildCanvas());
            renderingEngine.drawBufferOnScreen();
            GameTime.getInstance().sleep();
        }
    }
}
