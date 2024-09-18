package doctrina.engine.bouncingballgame;

import java.awt.Color;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.Game;
import doctrina.engine.engine.GameTime;

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
        canvas.renderString("Current time: " + GameTime.getInstance().getFormattedElapsedTime(), 10, 10, Color.white);
        canvas.renderString("FPS: " + GameTime.getInstance().getCurrentFps(), 10, 30, Color.white);
        canvas.renderString("Score: " + score, ball.getX() - 15, ball.getY() - 15, Color.WHITE);
    }

    @Override
    protected void conclude() {

    }
}
