package doctrina.engine.tank;

import java.awt.Color;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.controls.Direction;
import doctrina.engine.engine.entities.MovableEntity;

public class Missile extends MovableEntity {

    public Missile(Tank tank) {
        setDirection(tank.getDirection());
        init(tank);
    }

    @Override
    public void update() {
        move();
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(x, y, width, height, Color.PINK);
    }

    private void init(Tank tank) {
        if (direction == Direction.UP || direction == Direction.DOWN) {
            setDimension(2, 8);
            teleport(tank.getX() + (tank.getWidth() / 2) - width / 2,
                    tank.getY() + (tank.getHeight() / 2) - height / 2);
        } else if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            setDimension(8, 2);
            teleport(tank.getX() + (tank.getWidth() / 2) - width / 2,
                    tank.getY() + (tank.getHeight() / 2) - height / 2);
        }
        setSpeed(6);
    }
}
