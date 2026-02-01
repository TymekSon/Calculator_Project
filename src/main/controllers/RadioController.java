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
    }

    // Aktualizacja dostępności przycisków w zależności od bazy

}
