package main;

import main.ui.UI;
import main.ui.ui_elements.OutputPanel;

public class DisplayController {
    OutputPanel op;
    DisplayController(UI ui) {
        op = ui.getOutputPanel();
    }
}
