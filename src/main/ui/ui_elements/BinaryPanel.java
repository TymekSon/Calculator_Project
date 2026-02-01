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

    public void setBinaryDisplay(String binaryString){
        int requiredLength = 64;
        if (binaryString.length() > requiredLength) {
            binaryString = binaryString.substring(binaryString.length() - requiredLength);  // Przytnij jeśli dłuższy
        } else {
            binaryString = String.format("%" + requiredLength + "s", binaryString).replace(' ', '0');  // Uzupełnij zerami
        }

        for (int i = 0; i < 16; i++) {
            int start = i * 4;
            String bits = binaryString.substring(start, start + 4);
            quartets[i].update(bits);
        }
    }
    public void clear() {
        for (BinaryQuartet quartet : quartets) {
            quartet.update("0000");  // Lub quartet.setValue(0);
        }
    }
}
