package main;

import main.controllers.Controller;
import main.ui.UI;

public class Start {
    public static void main(String[] args){
        UI ui = new UI();
        Controller ctrl = new Controller(ui);
        ui.setVisible(true);
    }
}
