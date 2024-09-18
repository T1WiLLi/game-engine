package doctrina.engine.movingRectangle;

import java.awt.Color;

import doctrina.engine.engine.Canvas;

public class Player {
    private int x, y, speed;

    private Gamepad gamepad;

    public Player(Gamepad gamepad) {
        this.gamepad = gamepad;
        this.x = 200;
        this.y = 200;
        this.speed = 3;
    }

    public void update() {
        if (gamepad.isUpPressed()) {
            y -= speed;
        }
        if (gamepad.isDownPressed()) {
            y += speed;
        }
        if (gamepad.isLeftPressed()) {
            x -= speed;
        }
        if (gamepad.isRightPressed()) {
            x += speed;
        }
    }

    public void render(Canvas canvas) {
        canvas.renderRectangle(x, y, 20, 60, Color.WHITE);
    }
}
