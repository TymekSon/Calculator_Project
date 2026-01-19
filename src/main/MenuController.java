package main;


import main.ui.ui_elements.Menu;

public class MenuController {
    public Menu[] menu;
    public MenuController() {
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
