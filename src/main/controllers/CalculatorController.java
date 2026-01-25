package main.controllers;

import main.Calculator;

public class CalculatorController {

    private final Calculator calculator;
    private final UIController uiController;

    public CalculatorController(Calculator calculator, UIController uiController) {
        this.calculator = calculator;
        this.uiController = uiController;
    }

    // Calculation operations
    public void calculate() {
        calculator.calculate();
        uiController.updateDisplays();
    }

    // Number input
    public void inputNumber(String number) {
        calculator.inputNumber(number);
        uiController.updateDisplays();
    }

    // Operator input
    public void inputOperator(String operator) {
        calculator.inputOperator(operator);
        uiController.updateDisplays();
    }

    // Control operations
    public void backspace() {
        calculator.backspace();
        uiController.updateDisplays();
    }

    public void clear() {
        calculator.clear();
        uiController.updateDisplays();
    }

    public void clearEntry() {
        calculator.clearEntry();
        uiController.updateDisplays();
    }

    public void negate() {
        calculator.negate();
        uiController.updateDisplays();
    }

    // Memory operations
    public void memoryRecall() {
        calculator.memoryRecall();
        uiController.updateDisplays();
    }

    public void memoryStore() {
        calculator.memoryStore();
        uiController.updateDisplays();
    }

    public void memoryAdd() {
        calculator.memoryAdd();
        uiController.updateDisplays();
    }

    public void memorySubtract() {
        calculator.memorySubtract();
        uiController.updateDisplays();
    }

    public void memoryClear() {
        calculator.memoryClear();
        uiController.updateDisplays();
    }

    // Display getters (for initial setup or special cases)
    public String getDisplay() {
        return calculator.getDisplayValue();
    }

    public String getBinaryDisplay() {
        return calculator.getBinaryRepresentation();
    }
}