package doctrina.engine.engine.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public abstract class Controller implements KeyListener {

    private final HashMap<Integer, Boolean> pressedKeys;

    public Controller() {
        this.pressedKeys = new HashMap<>();
    }

    protected void bindKeys(int[] keys) {
        for (int key : keys) {
            pressedKeys.put(key, false);
        }
    }

    protected void bindKey(int key) {
        pressedKeys.put(key, false);
    }

    protected void clearKeys() {
        pressedKeys.clear();
    }

    protected void unbindKey(int key) {
        pressedKeys.remove(key);
    }

    protected boolean isKeyPressed(int key) {
        return pressedKeys.getOrDefault(key, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.computeIfPresent(e.getKeyCode(), (k, v) -> true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.computeIfPresent(e.getKeyCode(), (k, v) -> null);
    }
}
