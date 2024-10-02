package doctrina.engine.footprint;

import java.awt.Color;

import java.util.List;
import java.util.ArrayList;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.RenderingEngine;
import doctrina.engine.engine.entities.MovableEntity;

public class Player extends MovableEntity {
    private Gamepad gamepad;
    private List<Footprint> footprints = new ArrayList<>();

    public Player(Gamepad gamepad) {
        this.gamepad = gamepad;
        RenderingEngine.getInstance().addKeyListener(gamepad);
        teleport(200, 200);
        setDimension(20, 60);
        this.speed = 3;
    }

    public void update() {
        if (gamepad.isMoving()) {
            move(gamepad.getDirection());
        }
    }

    public void render(Canvas canvas) {
        footprints.forEach(fp -> fp.render(canvas));
        canvas.renderRectangle(x, y, width, height, Color.WHITE);
    }

    public Footprint createFootprint() {
        return new Footprint(x, y);
    }
}
