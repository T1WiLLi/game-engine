package doctrina.engine.tank;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.Game;

public class TankGame extends Game {

    private Tank tank;
    private Gamepad gamepad;

    private List<Missile> missiles = new ArrayList<>();
    private List<Brick> bricks = new ArrayList<>();

    @Override
    protected void init() {
        this.gamepad = new Gamepad();
        this.tank = new Tank(this.gamepad);
        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(500, 115));
        bricks.add(new Brick(500, 130));
        bricks.add(new Brick(500, 145));
    }

    @Override
    protected void update() {
        if (gamepad.isQuitPressed()) {
            stop();
        }
        if (gamepad.isFireKeyPressed() && tank.canFire()) {
            missiles.add(tank.fire());
        }
        tank.update();
        missiles.forEach(Missile::update);
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(0, 0, 800, 600, Color.BLUE);
        canvas.renderString("Cooldown: " + tank.getCooldown(), 10, 10, Color.RED);
        tank.render(canvas);
        missiles.forEach(missile -> missile.render(canvas));
        bricks.forEach(brick -> brick.render(canvas));
    }

    @Override
    protected void conclude() {
        System.exit(0);
    }
}
