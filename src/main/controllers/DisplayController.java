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

    public void updateBinary(String s){
        ui.getBinaryPanel().clear();
        ui.getBinaryPanel().setBinaryDisplay(s);
    }

    public void showError(String message) {
        UI ui = controller.getUI();
        ui.getOutputPanel().setMainDisplay(message);
        ui.getBinaryPanel().clear();
    }
}