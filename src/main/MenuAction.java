package main;

import java.util.function.Consumer;

public class MenuAction {
    public String name;
    public final Consumer<MenuController> action;

    MenuAction(String name, Consumer<MenuController> action) {
        this.name = name;
        this.action = action;
    }
}
