package doctrina.engine.movingRectangle;

import java.awt.event.KeyEvent;

import doctrina.engine.engine.controls.MovementController;

public class Gamepad extends MovementController {
    private int quitKey = KeyEvent.VK_ESCAPE;

    public Gamepad() {
        bindKey(quitKey);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }
}
