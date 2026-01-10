package main;

import javax.swing.*;
import java.awt.*;
public class UI {
    private final int windowSizeX_min = 400;
    private final int windowSizeY_min = 320;
    private final String title = "Calculator";
    private final String iconPath = "img/icon.png";
    public void drawUI(){
        Dimension windowSize_min = new Dimension(windowSizeX_min, windowSizeY_min);
        JFrame frame = new JFrame();
        frame.setMinimumSize(windowSize_min);
        ImageIcon icon = new ImageIcon(iconPath);
        frame.setIconImage(icon.getImage());
        JMenuBar bar = buildMenuBar();
        frame.setJMenuBar(bar);
        JPanel bg = drawBackground();
        frame.add(bg);
        frame.setTitle(title);
        frame.setVisible(true);
    }
    private JMenuBar buildMenuBar(){
        MenuController mc = new MenuController();
        JMenuBar mB = new JMenuBar();
        for (Menu m : mc.menu){
            JMenu jm = new JMenu(m.name);
            for(MenuAction ma : m.actions){
                JMenuItem item = new JMenuItem(ma.name);
                item.addActionListener(e->ma.action.accept(mc));
                jm.add(item);
            }
            mB.add(jm);
        }
        return mB;
    }
    private JPanel drawBackground(){
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int w = getWidth();
                int h = getHeight();
                Graphics2D g2 = (Graphics2D) g;
                Color bottom = new Color(217, 228, 241);
                Color up = new Color(237, 244, 252);
                GradientPaint gp = new GradientPaint(0, h, bottom, 0, 0, up);
                g2.setPaint(gp);
                g2.fillRect(0, 0, w, h);
            }
        };
    }


}
