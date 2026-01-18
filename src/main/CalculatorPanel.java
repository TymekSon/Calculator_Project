package main;

import javax.swing.*;
import java.awt.*;

public class CalculatorPanel {

}

class GenericPanel extends GradientPanel{
    Dimension dimension;
    public GenericPanel(UI.PanelSize ps, Direction dir){
        super(dir);
        dimension = ps.dim();
        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setBorder(new RoundedBorder(5));
    }
    public JPanel wrap(){
        JPanel w = new JPanel();
        w.setLayout(new BoxLayout(w, BoxLayout.X_AXIS));
        w.setMaximumSize(dimension);
        w.add(Box.createHorizontalGlue());
        w.add(this);
        w.add(Box.createHorizontalGlue());
        return w;
    }
}


