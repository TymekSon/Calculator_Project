package main.controllers;

import main.Calculator;
import main.NumericBase;
import main.WordSize;
import main.ui.UI;
import main.ui.ui_elements.CalculatorButton;

import java.util.Objects;

public class Controller {
    NumericBase base;
    WordSize wordSize;
    UI ui;
    DisplayController dc;
    InputController ic;
    RadioController rc;
    Calculator calc;
    public String buffer;
    public String upperBuffer;
    private CalculatorButton operator;
    public Controller(UI ui){
        this.base = NumericBase.DEC;
        this.wordSize = WordSize.QWORD;
        this.ui = ui;
        this.calc = new Calculator(wordSize, base);

        // Przekaż referencję do siebie, żeby podkontrolery mogły się komunikować
        this.dc = new DisplayController(this);
        this.ic = new InputController(this);
        this.rc = new RadioController(this);
        this.upperBuffer = "";
        this.buffer = "0";
        this.operator = null;

        dc.updateDisplay(buffer);
        ui.getButtonContainer().updateButtons(base);
    }

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
        ui.getButtonContainer().updateButtons(base);
    }

    public WordSize getWordSize() {
        return wordSize;
    }

    public void setWordSize(WordSize wordSize) {
        this.wordSize = wordSize;
        calc.setWordSize(wordSize);
    }

    public void addToBuffer(String s){
        if (Objects.equals(buffer, "0"))
            buffer = "";
        buffer += s;
        dc.updateDisplay(buffer);
    }
    public void addOperator(CalculatorButton cb){
        operator = cb;
        moveBuffer();
    }
    public void moveBuffer(){
        upperBuffer = buffer;
        buffer = "0";
    }
    public void executeFunction(String s){

    }
    public void clearBuffer(){
        buffer = "0";
        upperBuffer = "";
    }
    public void memoryAction(String s){

    }
    public void evaluate(){
        calc.evaluate();
    }
}