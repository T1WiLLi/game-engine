package doctrina.engine.movingRectangle;

import java.awt.Color;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.Game;

public class MovingRectangleGame extends Game {

    private Gamepad gamepad;

    private Player player;
    private Npc npc;

    @Override
    protected void init() {
        gamepad = new Gamepad();
        addKeyListener(gamepad);
        this.player = new Player(gamepad);
        this.npc = new Npc();
    }

    @Override
    protected void update() {
        if (gamepad.isQuitPressed()) {
            stop();
        }
        player.update();
        npc.update();
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(0, 0, 800, 600, Color.BLUE);
        player.render(canvas);
        npc.render(canvas);
    }

    @Override
    protected void conclude() {
        System.exit(0);
    }
}
