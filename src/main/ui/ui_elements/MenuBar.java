package main.ui.ui_elements;

import main.MenuAction;
import main.MenuController;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        MenuController mc = new MenuController();
        for (Menu m : mc.menu) {
            JMenu jm = new JMenu(m.name);
            for (MenuAction ma : m.actions) {
                JMenuItem item = new JMenuItem(ma.name);
                item.addActionListener(e -> ma.action.accept(mc));
                jm.add(item);
            }
            add(jm);
        }
    }
}
