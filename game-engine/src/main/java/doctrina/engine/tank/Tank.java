package doctrina.engine.tank;

import java.awt.Color;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.RenderingEngine;
import doctrina.engine.engine.controls.MovementController;
import doctrina.engine.engine.entities.ControllableEntity;

public class Tank extends ControllableEntity {

    private int cooldown = 0;

    public Tank(MovementController controller) {
        super(controller);
        RenderingEngine.getInstance().addKeyListener(controller);
        setDimension(50, 50);
        teleport(375, 275);
        setSpeed(3);
    }

    @Override
    public void update() {
        moveWithController();
        cooldown = (cooldown > 0) ? cooldown - 1 : 0;
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(this, Color.GREEN);
        int cooldownWidth = (cooldown * width) / 40;
        canvas.renderRectangle(x, y - 10, width, 5, Color.red);
        canvas.renderRectangle(x, y - 10, cooldownWidth, 5, Color.GRAY);
    }

    public Missile fire() {
        cooldown = 40;
        return new Missile(this);
    }

    public boolean canFire() {
        return cooldown == 0;
    }

    public int getCooldown() {
        return cooldown;
    }
}
