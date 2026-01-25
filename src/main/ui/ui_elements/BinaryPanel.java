package main.ui.ui_elements;

import main.ui.UI;

import javax.swing.*;
import java.awt.*;

public class BinaryPanel extends GradientPanel {
    BinaryQuartet[] quartets;
    public BinaryPanel(UI.PanelSize ps, UI.Direction direction) {
        super(direction);
        this.setBorder(new RoundedBorder(5));
        this.quartets = new BinaryQuartet[16];
        this.setMinimumSize(ps.dim());
        this.setLayout(new GridLayout(2, 8, 18, 0));
        for(int i = 0; i < 16; i++){
            int decimalValue = 63 - (i * 4);
            int alignment = 2;
            if(!(decimalValue == 63 || decimalValue == 47 || decimalValue == 31 || decimalValue == 15)){
                if(decimalValue == 35 || decimalValue == 3) {
                    decimalValue -= 3;
                    alignment = 4;
                }
                else
                    decimalValue = -1;

            }
            BinaryQuartet quartet = new BinaryQuartet(decimalValue, UI.PanelSize.QuartetPanel, alignment);
            this.add(quartet);
            this.quartets[i] = quartet;
        }
    }
}
