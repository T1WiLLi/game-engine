package doctrina.engine.footprint;

import java.awt.Color;

import java.util.List;
import java.util.ArrayList;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.Game;

public class FootprintGame extends Game {
    private Gamepad gamepad;
    private Gamepad gamepad2;

    private Player player;
    private Player player2;
    private List<Footprint> footprints = new ArrayList<>();

    @Override
    protected void init() {
        gamepad = new Gamepad();
        gamepad2 = new Gamepad();
        gamepad2.useArrow();
        this.player = new Player(gamepad);
        this.player2 = new Player(gamepad2);
    }

    @Override
    protected void update() {
        if (gamepad.isQuitPressed()) {
            stop();
        }
        if (gamepad2.isQuitPressed()) {
            stop();
        }
        player.update();
        player2.update();
        if (gamepad.isMoving()) {
            footprints.add(player.createFootprint());
        }
        if (gamepad2.isMoving()) {
            footprints.add(player2.createFootprint());
        }
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(0, 0, 800, 600, Color.BLUE);
        footprints.forEach(fp -> fp.render(canvas));
        player.render(canvas);
        player2.render(canvas);
    }

    @Override
    protected void conclude() {
        System.exit(0);
    }
}
