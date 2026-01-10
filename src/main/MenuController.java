package main;

import java.util.function.Consumer;
class Menu {
    String name;
    MenuAction[] actions;
    Menu(String name, MenuAction[] actions){
        this.name = name;
        this.actions = actions;
    }
}
class MenuAction {
    String name;
    final Consumer<MenuController> action;
    MenuAction(String name, Consumer<MenuController> action){
        this.name = name;
        this.action = action;
    }
}
public class MenuController {
    Menu[] menu;
    MenuController() {
        menu = new Menu[]{
                new Menu("View", items_View),
                new Menu("Edit", items_Edit),
                new Menu("Help", items_Help)
        };
    }
    private static final MenuAction[] items_View = {
            new MenuAction(
                    "View1",
                    MenuController::exampleMethod
            )
    };
    private static final MenuAction[] items_Edit = {
            new MenuAction(
                    "Edit1",
                    MenuController::exampleMethod
            ),
            new MenuAction(
                    "Edit2",
                    MenuController::exampleMethod
            )
    };
    private static final MenuAction[] items_Help = {
            new MenuAction(
                    "Help1",
                    MenuController::exampleMethod
            )
    };
    private void exampleMethod(){

    }
}
