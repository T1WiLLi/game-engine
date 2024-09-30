package doctrina.engine.footprint;

import java.awt.Color;

import java.util.List;
import java.util.ArrayList;

import doctrina.engine.engine.Canvas;
import doctrina.engine.engine.Game;

public class FootprintGame extends Game {
    private Gamepad gamepad;

    private Player player;
    private List<Footprint> footprints = new ArrayList<>();

    @Override
    protected void init() {
        gamepad = new Gamepad();
        this.player = new Player(gamepad);
    }

    @Override
    protected void update() {
        if (gamepad.isQuitPressed()) {
            stop();
        }
        player.update();
        if (gamepad.isMoving()) {
            footprints.add(player.createFootprint());
        }
    }

    @Override
    protected void render(Canvas canvas) {
        canvas.renderRectangle(0, 0, 800, 600, Color.BLUE);
        footprints.forEach(fp -> fp.render(canvas));
        player.render(canvas);
    }

    @Override
    protected void conclude() {
        System.exit(0);
    }
}
