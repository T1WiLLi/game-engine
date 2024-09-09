package doctrina.engine;

import java.awt.Color;
import java.util.Random;

public class Ball {

    public static final int DEFAULT_SPEED = 5;

    private int x, y, dx, dy, radius, speed;

    public Ball(int radius, int speed) {
        this.radius = radius;
        this.speed = speed;
        initPos();
    }

    public Ball(int radius) {
        this(radius, DEFAULT_SPEED);
    }

    private void initPos() {
        this.x = randomNumber(this.radius * 2, 800 - this.radius * 2);
        this.y = randomNumber(600 - this.radius * 2, this.radius * 2);
        this.dx = randomNumber(0, 1) == 0 ? this.speed : -this.speed;
        this.dy = randomNumber(0, 1) == 0 ? this.speed : -this.speed;
    }

    public void update() {
        x += dx;
        y += dy;
        if (hasTouchedVertical()) {
            dy *= -1;
        }

        if (hasTouchedHorizontal()) {
            dx *= -1;
        }
    }

    public void render(Canvas canvas) {
        canvas.renderCircle(x, y, this.radius, Color.RED);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private boolean hasTouchedVertical() {
        return y <= 0 || y >= 600 - this.radius * 2;
    }

    private boolean hasTouchedHorizontal() {
        return x <= 0 || x >= 800 - this.radius * 2;
    }

    public boolean hasTouched() {
        return hasTouchedVertical() || hasTouchedHorizontal();
    }

    private int randomNumber(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        return new Random().nextInt((max - min) + 1) + min;
    }
}
