package doctrina.engine.tank;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.entities.StaticEntity;

import java.awt.Color;

public class Brick extends StaticEntity {

    public Brick(int x, int y) {
        setDimension(10, 10);
        teleport(x, y);
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(this, Color.WHITE);
    }
}
