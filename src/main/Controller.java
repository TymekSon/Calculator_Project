package main;

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
    Controller(UI ui){
        base = NumericBase.DEC;
        wordSize = WordSize.QWORD;
        this.ui = ui;
        dc = new DisplayController(ui);
        ic = new InputController(ui);
        rc = new RadioController(ui);
        calc = new Calculator(wordSize, base);
        buffer = "";
    }
}
