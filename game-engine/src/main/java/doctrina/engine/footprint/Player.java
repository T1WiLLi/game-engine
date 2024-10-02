package doctrina.engine.footprint;

import java.awt.Color;

import java.util.List;
import java.util.ArrayList;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.RenderingEngine;
import doctrina.engine.engine.entities.ControllableEntity;

public class Player extends ControllableEntity {
    private List<Footprint> footprints = new ArrayList<>();

    public Player(Gamepad gamepad) {
        super(gamepad);
        RenderingEngine.getInstance().addKeyListener(gamepad);
        teleport(200, 200);
        setDimension(20, 60);
        this.speed = 3;
    }

    @Override
    public void update() {
        moveWithController();
    }

    @Override
    public void render(Canvas canvas) {
        footprints.forEach(fp -> fp.render(canvas));
        canvas.renderRectangle(x, y, width, height, Color.WHITE);
    }

    public Footprint createFootprint() {
        return new Footprint(x, y);
    }
}
