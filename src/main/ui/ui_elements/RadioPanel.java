package main.ui.ui_elements;

import main.ui.UI;

import javax.swing.*;
import java.awt.*;

public class RadioPanel extends CalculatorPanel {
    private final ButtonGroup group = new ButtonGroup();
    public RadioPanel(UI.PanelSize ps, UI.Direction dir, String[] options, String defaultSelected) {
        super(ps, dir);
        setOpaque(false);
        setMinimumSize(ps.dim());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (String text : options) {
            JRadioButton rb = new JRadioButton(text);
            rb.setAlignmentX(Component.LEFT_ALIGNMENT);
            rb.setBorder(BorderFactory.createEmptyBorder(4, 2, 0, 0));
            rb.setOpaque(false);
            rb.setFocusPainted(false);
            rb.setFont(UI.regularFont.deriveFont(9f));

            if (text.equals(defaultSelected)) {
                rb.setSelected(true);
            }

            group.add(rb);
            add(rb);
        }
    }

    public ButtonGroup getButtonGroup() {
        return group;
    }

}
