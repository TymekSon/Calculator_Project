package main.ui.ui_elements;

import main.ui.UI;

import java.awt.*;
public class CalculatorPanel extends GradientPanel {
    Dimension dimension;
    public CalculatorPanel(UI.PanelSize ps, UI.Direction dir){
        super(dir);
        dimension = ps.dim();
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setBorder(new RoundedBorder(5));
    }
}


