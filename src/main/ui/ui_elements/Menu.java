package main.ui.ui_elements;

import main.MenuAction;

public class Menu {
    public String name;
    public MenuAction[] actions;
    public Menu(String name, MenuAction[] actions){
        this.name = name;
        this.actions = actions;
    }
}