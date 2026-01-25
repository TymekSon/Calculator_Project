package main.controllers;

import main.Calculator;
import main.WordSize;
import main.ui.ui_elements.NumericBase;

public class RadioController {
    private final Calculator calculator;
    private final UIController uiController;

    public RadioController(Calculator calculator, UIController uiController) {
        this.calculator = calculator;
        this.uiController = uiController;
    }

    public void setWordSize(WordSize wordSize) {
        calculator.setWordSize(wordSize);
        uiController.updateDisplays();
    }

    public void setNumberSystem(NumericBase base) {
        calculator.setNumberSystem(base);
        uiController.updateDisplays();
    }
}