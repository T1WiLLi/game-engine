package doctrina.engine.engine;

import java.awt.Graphics2D;
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
        this.graphics2D.drawRect(x, y, width, height);
    }

    public Graphics2D getGraphics2D() {
        return this.graphics2D;
    }
}
