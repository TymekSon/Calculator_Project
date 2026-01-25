package main.controllers;

import main.Calculator;
import main.NumericBase;
import main.WordSize;
import main.ui.UI;

public class Controller {
    NumericBase base;
    WordSize wordSize;
    UI ui;
    DisplayController dc;
    InputController ic;
    RadioController rc;
    Calculator calc;
    public String buffer;

    public Controller(UI ui){
        this.base = NumericBase.DEC;
        this.wordSize = WordSize.QWORD;
        this.ui = ui;
        this.calc = new Calculator(wordSize, base);

        // Przekaż referencję do siebie, żeby podkontrolery mogły się komunikować
        this.dc = new DisplayController(this);
        this.ic = new InputController(this);
        this.rc = new RadioController(this);

        this.buffer = "";

        // Pierwsza aktualizacja wyświetlacza
        dc.updateDisplay();
    }

    // Metody dostępowe dla podkontrolerów
    public Calculator getCalculator() {
        return calc;
    }

    public UI getUI() {
        return ui;
    }

    public DisplayController getDisplayController() {
        return dc;
    }

    public NumericBase getBase() {
        return base;
    }

    public void setBase(NumericBase base) {
        this.base = base;
        calc.setBase(base);
    }

    public WordSize getWordSize() {
        return wordSize;
    }

    public void setWordSize(WordSize wordSize) {
        this.wordSize = wordSize;
        calc.setWordSize(wordSize);
    }
}