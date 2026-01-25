package main;

import main.ui.UI;
import main.ui.ui_elements.ButtonPanel;

public class InputController {
    ButtonPanel bp;
    InputController(UI ui){
        bp = ui.getButtonContainer();
    }
}
