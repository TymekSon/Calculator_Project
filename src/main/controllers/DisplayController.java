package main.controllers;

import main.Calculator;
import main.ui.UI;

public class DisplayController {
    private final Controller controller;

    public DisplayController(Controller controller) {
        this.controller = controller;
    }

    public void updateDisplay() {
        Calculator calc = controller.getCalculator();
        UI ui = controller.getUI();

        // Aktualizuj główny wyświetlacz
        String displayValue = calc.getDisplayValue();
        ui.getOutputPanel().setMainDisplay(displayValue);

        // Aktualizuj wyświetlacz binarny
        String binaryValue = calc.getBinaryRepresentation();
        ui.getOutputPanel().setUpperDisplay(binaryValue);
    }

    public void showError(String message) {
        UI ui = controller.getUI();
        ui.getOutputPanel().setMainDisplay(message);
        // Czyszczenie binary przy błędzie (opcjonalnie, aby uniknąć starej wartości)
        ui.getBinaryPanel().clear();
    }

    public void clearDisplay() {
        UI ui = controller.getUI();
        ui.getOutputPanel().setMainDisplay("0");
        ui.getBinaryPanel().clear();  // Użyj nowej metody clear
    }
}