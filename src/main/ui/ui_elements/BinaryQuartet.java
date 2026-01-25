package main.ui.ui_elements;

import main.ui.UI;

import javax.swing.*;
import java.awt.*;

public class BinaryQuartet extends JPanel {
    private JLabel binary;
    private JLabel decimal;
    private String binaryValue;
    private Font font = UI.regularFont.deriveFont(12.5f);
    BinaryQuartet(int decimal, UI.PanelSize ps, int alignment){

        this.setMinimumSize(ps.dim());
        this.setPreferredSize(ps.dim());
        this.binaryValue = "0000";
        this.binary = new JLabel(binaryValue);
        this.binary.setFont(font);
        this.decimal = new JLabel(String.valueOf(decimal));
        this.decimal.setFont(font);
        this.decimal.setHorizontalAlignment(alignment);
        if(decimal < 0){
            this.decimal.setText("");
        }
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(this.binary, BorderLayout.NORTH);
        this.add(this.decimal, BorderLayout.SOUTH);
    }
    void update(String bin){
        this.binaryValue = bin;
        this.binary.setText(binaryValue);
    }
}
