package doctrina.engine.engine.entities;

import doctrina.engine.engine.Canvas;

public abstract class StaticEntity {

    protected int x, y, width, height;

    protected abstract void render(Canvas canvas);

    public void teleport(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
