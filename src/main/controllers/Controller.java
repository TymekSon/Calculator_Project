package main.controllers;

import main.*;
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

    public String getBuffer(){
        return buffer;
    }

    public void setBase(NumericBase base) {
        NumericBase oldBase = this.base;
        this.base = base;
        calc.setBase(base);
        ui.getButtonContainer().updateButtons(base);
        buffer = StringNumberConverter.convert(
                buffer,
                oldBase,
                base,
                wordSize.getBits()
        );
        dc.updateDisplay(buffer);
        dc.updateBinary(StringNumberConverter.convert(
                buffer,
                base,
                NumericBase.BIN,
                wordSize.getBits()
        ));
    }

    public WordSize getWordSize() {
        return wordSize;
    }

    public void setWordSize(WordSize wordSize) {
        this.wordSize = wordSize;
        calc.setWordSize(wordSize);
    }

    public void addToBuffer(String s){
        String filtered = base.filterInput(s);
        if (buffer.equals("0"))
            buffer = "";
        buffer += filtered;
        dc.updateDisplay(buffer);
        dc.updateBinary(StringNumberConverter.convert(
                buffer,
                base,
                NumericBase.BIN,
                wordSize.getBits()
        ));
    }
    public void addOperator(CalculatorButton cb){
        System.out.println("Button label: '" + cb.label + "'");
        System.out.println("Button type: " + cb.category); // jeśli masz taką metodę
        System.out.println("addOperator: buffer = " + buffer);
        calc.inputNumber(buffer);
        calc.inputOperator(cb.label);

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
        dc.updateDisplay(buffer);
        dc.updateBinary(StringNumberConverter.convert(
                buffer,
                base,
                NumericBase.BIN,
                wordSize.getBits()
        ));
    }
    public void memoryAction(String s){

    }
    public void evaluate(){
        calc.inputNumber(buffer);

        String result = calc.evaluate();

        buffer = result;
        upperBuffer = result;

        dc.updateDisplay(buffer);
        dc.updateBinary(
                StringNumberConverter.convert(
                        buffer,
                        base,
                        NumericBase.BIN,
                        wordSize.getBits()
                )
        );
    }

    public void backspace() {
        if (buffer != null && !buffer.isEmpty() && !buffer.equals("0")) {
            buffer = buffer.substring(0, buffer.length() - 1);
        }
    }
    public void pasteToBuffer(String s){
        buffer = base.filterInput(s);
        dc.updateDisplay(buffer);
    }
}