package main.ui.ui_elements;

import main.NumericBase;
import main.ui.UI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static main.ui.ui_elements.CalculatorButton.*;

public class ButtonPanel extends JPanel {
    private final CalculatorButton[][] buttonLayout = {
            {BLANK, OP_MOD, HEX_A, MEM_CLEAR, MEM_RECALL, MEM_STORE, MEM_ADD, MEM_SUBTRACT},
            {PAREN_LEFT, PAREN_RIGHT, HEX_B, CTRL_BACKSPACE, CTRL_CLEAR_ENTRY, CTRL_CLEAR, OP_SIGN, FUNC_SQRT},
            {BIT_ROL, BIT_ROR, HEX_C, DIGIT_7, DIGIT_8, DIGIT_9, OP_DIVIDE, OP_PERCENT},
            {BIT_OR, BIT_XOR, HEX_D, DIGIT_4, DIGIT_5, DIGIT_6, OP_MULTIPLY, FUNC_RECIPROCAL},
            {BIT_LSHIFT, BIT_RSHIFT, HEX_E, DIGIT_1, DIGIT_2, DIGIT_3, OP_SUBTRACT, CTRL_EQUALS,},
            {BIT_NOT, BIT_AND, HEX_F, DIGIT_0, null, OP_DECIMAL, OP_ADD, null}
    };

    private final Map<CalculatorButton, JButton> buttonMap;

    public ButtonPanel(UI.PanelSize ps) {
        buttonMap = new HashMap<>();
        NumericBase nb = NumericBase.DEC;
        setMinimumSize(ps.dim());
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(2, 1, 1, 1);

        for (int i = 0; i < 8; i++) {
            gbc.gridx = i;
            for (int j = 0; j < 6; j++) {
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                if (buttonLayout[j][i] == null)
                    continue;

                CalculatorButton buttonType = buttonLayout[j][i];
                JButton butt = new CalcButton(UI.PanelSize.PanelButton.dim(), buttonType);

                buttonMap.put(buttonType, butt);

                if (!buttonType.base.contains(nb))
                    butt.setEnabled(false);
                if (buttonType == CTRL_EQUALS)
                    gbc.gridheight = 2;
                if (buttonType == DIGIT_0)
                    gbc.gridwidth = 2;

                gbc.gridy = j;
                add(butt, gbc);
                revalidate();
                repaint();
            }
        }
    }

    public void updateButtons(NumericBase nb) {
        buttonMap.forEach((buttonType, button) -> {
            button.setEnabled(buttonType.base.contains(nb));
        });
        revalidate();
        repaint();
    }

    public Map<CalculatorButton, JButton> getButtonMap(){
        return buttonMap;
    }
}