package main;

import main.ui.UI;
import main.ui.ui_elements.RadioPanel;

public class RadioController {
    RadioPanel basep;
    RadioPanel wsp;
    RadioController(UI ui){
        basep = ui.getBaseRadioPanel();
        wsp = ui.getWordSizePanel();
    }
}
