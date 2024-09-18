package doctrina.engine.engine.controls;

import java.awt.event.KeyEvent;

public class MovementController extends Controller {

    private int upKey = KeyEvent.VK_W;
    private int downKey = KeyEvent.VK_S;
    private int leftKey = KeyEvent.VK_A;
    private int rightKey = KeyEvent.VK_D;

    public MovementController() {
        int[] keys = { upKey, downKey, leftKey, rightKey };
        bindKeys(keys);
    }

    public boolean isLeftPressed() {
        return isKeyPressed(leftKey);
    }

    public boolean isRightPressed() {
        return isKeyPressed(rightKey);
    }

    public boolean isUpPressed() {
        return isKeyPressed(upKey);
    }

    public boolean isDownPressed() {
        return isKeyPressed(downKey);
    }

    public boolean isMoving() {
        return isLeftPressed() || isRightPressed()
                || isUpPressed() || isDownPressed();
    }

    public void setUpKey(int upKey) {
        unbindKey(this.upKey);
        bindKey(upKey);
        this.upKey = upKey;
    }

    public void setDownKey(int downKey) {
        unbindKey(this.downKey);
        bindKey(downKey);
        this.downKey = downKey;
    }

    public void setLeftKey(int leftKey) {
        unbindKey(this.leftKey);
        bindKey(leftKey);
        this.leftKey = leftKey;
    }

    public void setRightKey(int rightKey) {
        unbindKey(this.rightKey);
        bindKey(rightKey);
        this.rightKey = rightKey;
    }
}
