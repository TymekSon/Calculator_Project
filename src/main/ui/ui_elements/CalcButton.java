package main.ui.ui_elements;

import javax.swing.*;
import java.awt.*;

public class CalcButton extends JButton {
    public CalcButton(Dimension d, CalculatorButton cb) {
        Font currentFont = this.getFont();
        this.setFont(currentFont.deriveFont(12f));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setMargin(new Insets(0,0,0,0));
        this.setText(cb.label);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        setFocusPainted(false);
    }
}
