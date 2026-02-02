package main.controllers;

import main.NumericBase;
import main.WordSize;
import main.ui.UI;
import main.ui.ui_elements.ButtonPanel;
import main.ui.ui_elements.CalculatorButton;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
        keyBindings();
    }
    public void attachButtonActions() {
        Map<CalculatorButton, JButton> buttonMap = ui.getButtonContainer().getButtonMap();
        buttonMap.forEach((buttonType, button) -> {
            button.addActionListener(e -> {
                switch (buttonType.category) {
                    case DIGIT, HEX:
                        controller.addToBuffer(buttonType.label);
                        break;
                    case OPERATOR, BITWISE:
                        controller.addOperator(buttonType);
                        break;
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
    public void keyBindings(){
        ButtonPanel panel = ui.getButtonContainer();
        InputMap im = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = panel.getActionMap();
        for (int i = 0; i <= 9; i++) {
            String key = Integer.toString(i);
            im.put(KeyStroke.getKeyStroke(key), "digit" + i);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0 + i, 0), "digit" + i);
            int digit = i;
            am.put("digit" + i, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.addToBuffer(key);
                }
            });
        }
        String[] hexLetters = { "A", "B", "C", "D", "E", "F" };

        for (String letter : hexLetters) {
            im.put(KeyStroke.getKeyStroke(letter), "hex" + letter);
            am.put("hex" + letter, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.addToBuffer(letter);
                }
            });

            im.put(KeyStroke.getKeyStroke(letter.toLowerCase()), "hex" + letter);
            am.put("hex" + letter, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.addToBuffer(letter);
                }
            });
        }
        im.put(KeyStroke.getKeyStroke('+'), "add");
        am.put("add", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addOperator(CalculatorButton.OP_ADD);
            }
        });
        im.put(KeyStroke.getKeyStroke('-'), "subtract");
        am.put("subtract", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addOperator(CalculatorButton.OP_SUBTRACT);
            }
        });
        im.put(KeyStroke.getKeyStroke('*'), "multiply");
        am.put("multiply", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addOperator(CalculatorButton.OP_MULTIPLY);
            }
        });
        im.put(KeyStroke.getKeyStroke('/'), "divide");
        am.put("divide", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addOperator(CalculatorButton.OP_DIVIDE);
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");
        am.put("backspace", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.backspace();
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "equals");
        am.put("equals", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.evaluate();
            }
        });
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK), "copy");
        am.put("copy", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyToClipboard(controller.getBuffer());
            }
        });

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK), "paste");
        am.put("paste", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasteFromClipboard();
            }
        });
    }
    public void copyToClipboard(String text) {
        if (text == null || text.isEmpty()) return;

        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }
    public void pasteFromClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                String data = (String) clipboard.getData(DataFlavor.stringFlavor);
                if (data != null && !data.isEmpty()) {
                    controller.pasteToBuffer(data.trim());
                }
            }
        } catch (Exception _) {
        }
    }
}