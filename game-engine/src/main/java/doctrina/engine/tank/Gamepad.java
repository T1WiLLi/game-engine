package doctrina.engine.tank;

import java.awt.event.KeyEvent;

import doctrina.engine.engine.controls.MovementController;

public class Gamepad extends MovementController {
    private int quitKey = KeyEvent.VK_ESCAPE;
    private int fireKey = KeyEvent.VK_SPACE;

    public Gamepad() {
        bindKey(quitKey);
        bindKey(fireKey);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }

    public boolean isFireKeyPressed() {
        return isKeyPressed(fireKey);
    }
}
