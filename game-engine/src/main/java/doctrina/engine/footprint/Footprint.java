package doctrina.engine.footprint;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.entities.StaticEntity;

import java.awt.Color;

public class Footprint extends StaticEntity {
    public Footprint(final int x, final int y) {
        teleport(x, y);
        setDimension(2, 2);
    }

    @Override
    public void render(Canvas canvas) {
        canvas.renderRectangle(this, new Color(getRandomValue(), getRandomValue(), getRandomValue()));
    }

    private int getRandomValue() {
        return (int) (Math.random() * 256);
    }
}
