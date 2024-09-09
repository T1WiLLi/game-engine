package doctrina.engine;

import java.awt.Color;
import java.awt.Graphics2D;

public class BouncingBallGame extends Game {

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
    public void drawOnBuffer(Graphics2D bufferEngine) {
        ball.draw(bufferEngine);

        bufferEngine.setPaint(Color.WHITE);
        bufferEngine.drawString("Score: " + score, ball.getX() - 15, ball.getY() - 15);
    }
}
