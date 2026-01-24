package main.ui.ui_elements;

import main.ui.UI;

import javax.swing.*;
import java.awt.*;

public class CalcButton extends JButton {
    public CalcButton(Dimension d, CalculatorButton cb) {
        setFont(UI.regularFont.deriveFont(12f));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setMargin(new Insets(0,0,0,0));
        setText(cb.label);
        setPreferredSize(d);
        setFocusPainted(false);
    }
}
