package main.controllers;

import main.Calculator;
import javax.swing.JLabel;

public class UIController {
    private final Calculator calculator;
    private JLabel mainDisplay;
    private JLabel binaryDisplay;

    public UIController(Calculator calculator) {
        this.calculator = calculator;
    }

    public void setDisplays(JLabel mainDisplay, JLabel binaryDisplay) {
        this.mainDisplay = mainDisplay;
        this.binaryDisplay = binaryDisplay;
    }

    public void updateDisplays() {
        if (mainDisplay != null) {
            mainDisplay.setText(calculator.getDisplayValue());
        }
        if (binaryDisplay != null) {
            binaryDisplay.setText(calculator.getBinaryRepresentation());
        }
    }
}