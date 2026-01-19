package main.ui.ui_elements;

import javax.swing.*;
import java.awt.*;

public class CalcButton extends JButton {
    Color color1 = new Color(217, 228, 241);
    Color color2 = new Color(237, 244, 252);

    public CalcButton(Dimension d, CalculatorButton cb) {
        this.setText(cb.label);
        this.setBorder(new RoundedBorder(5));
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp;
        gp = new GradientPaint(0, h, color2, 0, 0, color1);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
        super.paintComponent(g);
    }
}
