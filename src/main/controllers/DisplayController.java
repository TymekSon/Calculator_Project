package main.controllers;

import main.Calculator;
import main.ui.UI;

public class DisplayController {
    private final Controller controller;
    UI ui;
    public DisplayController(Controller controller) {
        this.controller = controller;
        ui = controller.getUI();
    }

    public void updateDisplay(String buffer) {
        ui.getOutputPanel().setMainDisplay(buffer);
    }

    public void showError(String message) {
        UI ui = controller.getUI();
        ui.getOutputPanel().setMainDisplay(message);
        // Czyszczenie binary przy błędzie (opcjonalnie, aby uniknąć starej wartości)
        ui.getBinaryPanel().clear();
    }
}