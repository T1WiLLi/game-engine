package doctrina.engine;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {

    private JPanel panel;

    public GameWindow() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Game-engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setState(JFrame.NORMAL);

        this.panel = new JPanel();
        this.panel.setBackground(Color.BLUE);
        this.panel.setFocusable(true);
        this.panel.setDoubleBuffered(true);

        add(panel);
    }

    public void start() {
        setVisible(true);
    }
}
