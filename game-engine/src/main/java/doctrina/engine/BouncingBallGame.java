package doctrina.engine;

import java.awt.Color;

public final class BouncingBallGame extends Game {

    private int score = 0;
    private Ball ball;

    @Override
    public void init() {
        ball = new Ball(25);
    }

    @Override
    public void update() {
        ball.update();
        if (ball.hasTouched()) {
            score += 10;
        }
    }

    @Override
    public void render(Canvas canvas) {
        ball.render(canvas);
        canvas.renderString("Score: " + score, ball.getX() - 15, ball.getY() - 15, Color.WHITE);
    }
}
