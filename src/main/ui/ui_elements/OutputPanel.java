package main.ui.ui_elements;

import main.ui.UI;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends CalculatorPanel{
    JLabel upperLabel;
    JLabel mainLabel;
    public OutputPanel(UI.PanelSize ps, UI.Direction dir) {
        super(ps, dir);
        this.setLayout(new BorderLayout());
        upperLabel = new JLabel();
        upperLabel.setPreferredSize(UI.PanelSize.OutputLabel.dim());
        mainLabel = new JLabel();
        mainLabel.setText("0");
        mainLabel.setFont(UI.semiboldFont.deriveFont(20f));
        mainLabel.setOpaque(false);
        mainLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        mainLabel.setPreferredSize(UI.PanelSize.OutputLabel.dim());
        this.add(upperLabel, BorderLayout.NORTH);
        this.add(mainLabel, BorderLayout.CENTER);
    }
    public void display(String value){
        mainLabel.setText(value);
    }

    public void setMainDisplay(String value) {
        mainLabel.setText(value);  // Lub wywołaj display(value)
    }

    // Opcjonalnie: Jeśli upperLabel ma być używany
    public void setUpperDisplay(String value) {
        upperLabel.setText(value);
    }
}
