package doctrina.engine.movingRectangle;

import java.awt.Color;

import doctrina.engine.engine.Canvas;

public class Npc {
    private int x, y, speed;
    private boolean path1 = true;
    private boolean path2 = false;
    private boolean path3 = false;
    private boolean path4 = false;

    public Npc() {
        x = 400;
        y = 200;
        speed = 2;
    }

    public void update() {
        if (path1) {
            y += speed;
            if (y >= 500) {
                path1 = false;
                path2 = true;
            }
        } else if (path2) {
            x -= speed;
            if (x <= 100) {
                path2 = false;
                path3 = true;
            }
        } else if (path3) {
            y -= speed;
            if (y <= 200) {
                path3 = false;
                path4 = true;
            }
        } else if (path4) {
            x += speed;
            if (x >= 400) {
                path4 = false;
                path1 = true;
            }
        }
    }

    public void render(Canvas canvas) {
        canvas.renderRectangle(x, y, 40, 60, Color.white);
    }
}
