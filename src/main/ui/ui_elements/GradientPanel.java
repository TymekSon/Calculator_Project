package main.ui.ui_elements;

import main.ui.UI;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    Color color1 = new Color(217, 228, 241);
    Color color2 = new Color(237, 244, 252);
    private final UI.Direction direction;

    public GradientPanel(UI.Direction direction) {
        this.direction = direction;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp;
        if (direction == UI.Direction.topdown) {
            gp = new GradientPaint(0, h, color2, 0, 0, color1);
        } else {
            gp = new GradientPaint(0, h, color1, 0, 0, color2);
        }

        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
    }
}
