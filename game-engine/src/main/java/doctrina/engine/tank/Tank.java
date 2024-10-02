package doctrina.engine.tank;

import java.awt.Color;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.RenderingEngine;
import doctrina.engine.engine.controls.MovementController;
import doctrina.engine.engine.entities.ControllableEntity;

public class Tank extends ControllableEntity {

    public Tank(MovementController controller) {
        super(controller);
        RenderingEngine.getInstance().addKeyListener(controller);
        setDimension(50, 50);
        teleport(375, 275);
        speed = 3;
    }

    @Override
    public void update() {
        moveWithController();
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(this, Color.GREEN);
    }
}
