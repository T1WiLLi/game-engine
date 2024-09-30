package doctrina.engine.footprint;

import java.awt.Color;

import java.util.List;
import java.util.ArrayList;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.RenderingEngine;

public class Player {
    private int x, y, speed;

    private Gamepad gamepad;
    private List<Footprint> footprints = new ArrayList<>();

    public Player(Gamepad gamepad) {
        this.gamepad = gamepad;
        RenderingEngine.getInstance().addKeyListener(gamepad);
        this.x = 200;
        this.y = 200;
        this.speed = 3;
    }

    public void update() {
        float dx = 0;
        float dy = 0;

        if (gamepad.isUpPressed()) {
            dy -= speed;
        }
        if (gamepad.isDownPressed()) {
            dy += speed;
        }
        if (gamepad.isLeftPressed()) {
            dx -= speed;
        }
        if (gamepad.isRightPressed()) {
            dx += speed;
        }

        float length = (float) Math.sqrt(dx * dx + dy * dy);
        if (length != 0) {
            dx /= length;
            dy /= length;
        }

        x += dx * speed;
        y += dy * speed;
    }

    public void render(Canvas canvas) {
        footprints.forEach(fp -> fp.render(canvas));
        canvas.renderRectangle(x, y, 20, 60, Color.WHITE);
    }

    public Footprint createFootprint() {
        return new Footprint(x, y);
    }
}
