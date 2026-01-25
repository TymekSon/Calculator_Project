package main.controllers;

public class InputController {
    private final Controller controller;

    public InputController(Controller controller) {
        this.controller = controller;
    }

    // Cyfry
    public void inputDigit(String digit) {
        try {
            controller.getCalculator().inputNumber(digit);
            controller.getDisplayController().updateDisplay();
        } catch (Exception e) {
            controller.getDisplayController().showError("Error");
        }
    }

    // Operatory
    public void inputOperator(String operator) {
        try {
            controller.getCalculator().inputOperator(operator);
            controller.getDisplayController().updateDisplay();
        } catch (Exception e) {
            controller.getDisplayController().showError("Error");
        }
    }

    // Obliczenia
    public void calculate() {
        try {
            controller.getCalculator().calculate();
            controller.getDisplayController().updateDisplay();
        } catch (ArithmeticException e) {
            controller.getDisplayController().showError("Cannot divide by 0");
        } catch (Exception e) {
            controller.getDisplayController().showError("Error");
        }
    }

    // Kontrolki
    public void clear() {
        controller.getCalculator().clear();
        controller.buffer = "";
        controller.getDisplayController().updateDisplay();
    }

    public void clearEntry() {
        controller.getCalculator().clearEntry();
        controller.getDisplayController().updateDisplay();
    }

    public void backspace() {
        controller.getCalculator().backspace();
        controller.getDisplayController().updateDisplay();
    }

    public void negate() {
        try {
            controller.getCalculator().negate();
            controller.getDisplayController().updateDisplay();
        } catch (Exception e) {
            controller.getDisplayController().showError("Error");
        }
    }

    // Pamięć
    public void memoryStore() {
        controller.getCalculator().memoryStore();
        controller.getDisplayController().updateDisplay();
    }

    public void memoryRecall() {
        controller.getCalculator().memoryRecall();
        controller.getDisplayController().updateDisplay();
    }

    public void memoryAdd() {
        controller.getCalculator().memoryAdd();
        controller.getDisplayController().updateDisplay();
    }

    public void memorySubtract() {
        controller.getCalculator().memorySubtract();
        controller.getDisplayController().updateDisplay();
    }

    public void memoryClear() {
        controller.getCalculator().memoryClear();
        controller.getDisplayController().updateDisplay();
    }
}