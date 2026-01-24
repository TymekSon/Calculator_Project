package main.controllers;

import main.Calculator;

public class CalculatorController {

    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    public void calculate() {
        calculator.calculate();
    }

    public String getDisplay() {
        return calculator.getDisplayValue();
    }

    public void inputNumber(String number){
        calculator.inputNumber(number);
    }

    public void inputOperator(String operator){
        calculator.inputOperator(operator);
    }

    public void memoryRecall(){
        calculator.memoryRecall();
    }

    public void memoryStore(){
        calculator.memoryStore();
    }

    public void memoryAdd(){
        calculator.memoryAdd();
    }

    public void memorySubtract(){
        calculator.memorySubtract();
    }

    public void memoryClear(){
        calculator.memoryClear();
    }
}

