package main.controllers;

import main.NumericBase;
import main.WordSize;
import main.ui.UI;

public class RadioController {
    private final Controller controller;

    public RadioController(Controller controller) {
        this.controller = controller;
    }

    // Zmiana systemu liczbowego
    public void changeBase(String baseName) {
        NumericBase newBase = switch(baseName.toUpperCase()) {
            case "HEX" -> NumericBase.HEX;
            case "DEC" -> NumericBase.DEC;
            case "OCT" -> NumericBase.OCT;
            case "BIN" -> NumericBase.BIN;
            default -> NumericBase.DEC;
        };

        controller.setBase(newBase);
        controller.getDisplayController().updateDisplay();
        updateButtonStates();
    }

    // Zmiana rozmiaru słowa
    public void changeWordSize(String sizeName) {
        WordSize newSize = switch(sizeName.toUpperCase()) {
            case "QWORD" -> WordSize.QWORD;
            case "DWORD" -> WordSize.DWORD;
            case "WORD" -> WordSize.WORD;
            case "BYTE" -> WordSize.BYTE;
            default -> WordSize.QWORD;
        };

        controller.setWordSize(newSize);
        controller.getDisplayController().updateDisplay();
    }

    // Aktualizacja dostępności przycisków w zależności od bazy
    private void updateButtonStates() {
        UI ui = controller.getUI();
        NumericBase base = controller.getBase();

        // Dla każdej bazy inne cyfry są dostępne
        switch(base) {
            case HEX:
                // Wszystkie przyciski dostępne (0-9, A-F)
                ui.getButtonContainer().enableHexButtons(true);
                ui.getButtonContainer().enableOctButtons(true);
                ui.getButtonContainer().enableDecButtons(true);
                ui.getButtonContainer().enableBinButtons(true);
                break;
            case DEC:
                // Tylko 0-9
                ui.getButtonContainer().enableHexButtons(false);
                ui.getButtonContainer().enableOctButtons(true);
                ui.getButtonContainer().enableDecButtons(true);
                ui.getButtonContainer().enableBinButtons(true);
                break;
            case OCT:
                // Tylko 0-7
                ui.getButtonContainer().enableHexButtons(false);
                ui.getButtonContainer().enableOctButtons(true);
                ui.getButtonContainer().enableDecButtons(false);
                ui.getButtonContainer().enableBinButtons(true);
                break;
            case BIN:
                // Tylko 0-1
                ui.getButtonContainer().enableHexButtons(false);
                ui.getButtonContainer().enableOctButtons(false);
                ui.getButtonContainer().enableDecButtons(false);
                ui.getButtonContainer().enableBinButtons(true);
                break;
        }
    }
}
