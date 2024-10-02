package doctrina.engine.engine;

import java.awt.Graphics2D;

import doctrina.engine.engine.entities.StaticEntity;

import java.awt.Color;

public class Canvas {

    private Graphics2D graphics2D;

    public Canvas(Graphics2D graphics2d) {
        this.graphics2D = graphics2d;
    }

    public void renderString(String text, int x, int y, Color color) {
        this.graphics2D.setPaint(color);
        this.graphics2D.drawString(text, x, y);
    }

    public void renderCircle(int x, int y, int radius, Color color) {
        this.graphics2D.setPaint(color);
        this.graphics2D.fillOval(x, y, radius * 2, radius * 2);
    }

    public void renderRectangle(int x, int y, int width, int height, Color color) {
        this.graphics2D.setPaint(color);
        this.graphics2D.fillRect(x, y, width, height);
    }

    public void renderRectangle(StaticEntity entity, Color color) {
        this.graphics2D.setPaint(color);
        this.graphics2D.fillRect(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
    }

    public Graphics2D getGraphics2D() {
        return this.graphics2D;
    }
}
