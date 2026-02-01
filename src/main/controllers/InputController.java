package main.controllers;

import main.NumericBase;
import main.WordSize;
import main.ui.UI;
import main.ui.ui_elements.CalculatorButton;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class InputController {
    private final Controller controller;
    private final UI ui;
    private final List<JRadioButton> baseRadios;
    private final List<JRadioButton> wordRadios;
    public InputController(Controller controller) {
        this.controller = controller;
        ui = controller.ui;
        baseRadios = Collections.list(ui.getBaseRadioPanel()
                .getButtonGroup()
                .getElements())
                .stream()
                .map(b->(JRadioButton) b)
                .toList();
        wordRadios = Collections.list(ui.getWordSizePanel()
                .getButtonGroup()
                .getElements())
                .stream()
                .map(b->(JRadioButton) b)
                .toList();
        for(JRadioButton jrb : baseRadios){
            ActionListener al = null;
            switch(jrb.getText()){
                case "Hex":
                    al = e->controller.setBase(NumericBase.HEX);
                    break;
                case "Dec":
                    al = e->controller.setBase(NumericBase.DEC);
                    break;
                case "Bin":
                    al = e->controller.setBase(NumericBase.BIN);
                    break;
                case "Oct":
                    al = e->controller.setBase(NumericBase.OCT);
                    break;
            }
            jrb.addActionListener(al);
        }
        for(JRadioButton jrb : wordRadios){
            ActionListener al = null;
            switch(jrb.getText()){
                case "QWord":
                    al = e->controller.setWordSize(WordSize.QWORD);
                    break;
                case "Dword":
                    al = e->controller.setWordSize(WordSize.DWORD);
                    break;
                case "Word":
                    al = e->controller.setWordSize(WordSize.WORD);
                    break;
                case "Byte":
                    al = e->controller.setWordSize(WordSize.BYTE);
                    break;
            }
            jrb.addActionListener(al);
        }
        attachButtonActions();
    }
    public void attachButtonActions() {
        Map<CalculatorButton, JButton> buttonMap = ui.getButtonContainer().getButtonMap();
        buttonMap.forEach((buttonType, button) -> {
            button.addActionListener(e -> {
                switch (buttonType.category) {
                    case DIGIT, HEX:
                        controller.addToBuffer(buttonType.label);
                        break;
                    case OPERATOR:
                        controller.addOperator(buttonType);
                    case FUNCTION:
                        controller.executeFunction(buttonType.label);
                        break;
                    case MEMORY:
                        controller.memoryAction(buttonType.label);
                        break;
                    case CONTROL:
                        if (buttonType == CalculatorButton.CTRL_CLEAR)
                            controller.clearBuffer();
                        else if (buttonType == CalculatorButton.CTRL_EQUALS)
                            controller.evaluate();
                        break;
                }
            });
        });
    }

}