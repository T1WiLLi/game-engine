package doctrina.engine.tank;

import java.awt.Color;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.Game;

public class TankGame extends Game {

    private Tank tank;
    private Gamepad gamepad;

    @Override
    protected void init() {
        this.gamepad = new Gamepad();
        this.tank = new Tank(this.gamepad);
    }

    @Override
    protected void update() {
        if (gamepad.isQuitPressed()) {
            stop();
        }
        tank.update();
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(0, 0, 800, 600, Color.BLUE);
        tank.render(canvas);
    }

    @Override
    protected void conclude() {
        System.exit(0);
    }
}
