package main.controllers;

import main.action.ButtonAction;
import java.util.List;

public class KeyboardController {

    public final List<ButtonAction> buttons;

    public KeyboardController(CalculatorController controller) {
        buttons = List.of(
                new ButtonAction("=", controller::calculate),

                // numbers decimal
                new ButtonAction("0", () -> controller.inputNumber("0")),
                new ButtonAction("1", () -> controller.inputNumber("1")),
                new ButtonAction("2", () -> controller.inputNumber("2")),
                new ButtonAction("3", () -> controller.inputNumber("3")),
                new ButtonAction("4", () -> controller.inputNumber("4")),
                new ButtonAction("5", () -> controller.inputNumber("5")),
                new ButtonAction("6", () -> controller.inputNumber("6")),
                new ButtonAction("7", () -> controller.inputNumber("7")),
                new ButtonAction("8", () -> controller.inputNumber("8")),
                new ButtonAction("9", () -> controller.inputNumber("9")),

                // numbers hexagonal
                new ButtonAction("A", () -> controller.inputNumber("A")),
                new ButtonAction("B", () -> controller.inputNumber("B")),
                new ButtonAction("C", () -> controller.inputNumber("C")),
                new ButtonAction("D", () -> controller.inputNumber("D")),
                new ButtonAction("E", () -> controller.inputNumber("E")),
                new ButtonAction("F", () -> controller.inputNumber("F")),

                // arithmetic operators
                new ButtonAction("+", () -> controller.inputOperator("+")),
                new ButtonAction("-", () -> controller.inputOperator("-")),
                new ButtonAction("*", () -> controller.inputOperator("*")),
                new ButtonAction("/", () -> controller.inputOperator("/")),

                // bit operators
                new ButtonAction("AND", () -> controller.inputOperator("AND")),
                new ButtonAction("OR", () -> controller.inputOperator("AND")),
                new ButtonAction("XOR", () -> controller.inputOperator("AND")),
                new ButtonAction("NOT", () -> controller.inputOperator("AND")),

                // bit shifts
                new ButtonAction(">>", () -> controller.inputOperator(">>")),
                new ButtonAction("<<", () -> controller.inputOperator("<<")),

                // memory
                new ButtonAction("MR", () -> controller.memoryRecall()),
                new ButtonAction("M+", () -> controller.memoryRecall()),
                new ButtonAction("M-", () -> controller.memoryRecall()),
                new ButtonAction("MC", () -> controller.memoryRecall()),
                new ButtonAction("MS", () -> controller.memoryRecall())
        );
    }
}