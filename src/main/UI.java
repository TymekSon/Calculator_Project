package main;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

import static main.CalculatorButton.*;

enum Direction{
    topdown,
    bottomup
}
public class UI extends JFrame{
    private static final int windowSizeX_min = 400;
    private static final int windowSizeY_min = 350;
    private final String title = "Calculator";
    private final String iconPath = "img/icon.png";
    CalculatorButton[][] buttonLayout = {
            { BLANK, OP_MOD, HEX_A, MEM_CLEAR, MEM_RECALL, MEM_STORE, MEM_ADD, MEM_SUBTRACT },
            { PAREN_LEFT, PAREN_RIGHT, HEX_B, CTRL_BACKSPACE, CTRL_CLEAR_ENTRY, CTRL_CLEAR, OP_SIGN, FUNC_SQRT  },
            { BIT_ROL, BIT_ROR, HEX_C, DIGIT_7, DIGIT_8, DIGIT_9, OP_DIVIDE, OP_PERCENT },
            { BIT_OR, BIT_XOR, HEX_D, DIGIT_4, DIGIT_5, DIGIT_6, OP_MULTIPLY, FUNC_RECIPROCAL},
            { BIT_LSHIFT, BIT_RSHIFT, HEX_E, DIGIT_1, DIGIT_2, DIGIT_3, OP_SUBTRACT, CTRL_EQUALS,},
            { BIT_NOT, BIT_AND, HEX_F, DIGIT_0, null, OP_DECIMAL,  OP_ADD, null }
    };
    public UI(){
        Dimension windowSize_min = new Dimension(windowSizeX_min, windowSizeY_min);
        this.setMinimumSize(windowSize_min);
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());
        JMenuBar bar = buildMenuBar();
        this.setJMenuBar(bar);
        JPanel bg = new GradientPanel(Direction.bottomup);
        bg.setLayout(new BorderLayout());
        bg.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.NORTH);
        bg.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);
        bg.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
        bg.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);

        JPanel outp = new GenericPanel(PanelSize.PanelOut, Direction.topdown);
        JPanel binp = new GenericPanel(PanelSize.PanelBinary, Direction.topdown);

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BorderLayout());

        JPanel mp = new JPanel();
        mp.setPreferredSize(new Dimension((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.35)));
        mp.setMaximumSize(new Dimension((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.35)));
        mp.setLayout(new BorderLayout(0, 10));
        mp.setOpaque(false);
        mp.add(outp, BorderLayout.NORTH);
        mp.add(binp, BorderLayout.CENTER);
        content.add(mp, BorderLayout.NORTH);
        JPanel btp = new JPanel();
        btp.setOpaque(false);
        btp.setLayout(new BorderLayout());
        JPanel radioContainer = getRadioContainer();
        btp.add(radioContainer, BorderLayout.WEST);
        btp.add(getButtonContainer(), BorderLayout.CENTER);
        content.add(btp, BorderLayout.CENTER);
        bg.add(content, BorderLayout.CENTER);
        this.setResizable(false);
        this.add(bg);
        this.setTitle(title);
        this.setVisible(true);
    }

    private static JPanel getRadioContainer() {
        JPanel radioContainer = new JPanel();
        radioContainer.setLayout(new GridLayout(2,1));
        radioContainer.setMinimumSize(new Dimension((int) (windowSizeX_min*0.15), 0));
        radioContainer.setMaximumSize(new Dimension((int) (windowSizeX_min*0.15), 0));
        radioContainer.setOpaque(false);
        JPanel radio1 = new GenericPanel(PanelSize.PanelRadio, Direction.topdown);
        JPanel radio2 = new GenericPanel(PanelSize.PanelRadio, Direction.topdown);
        radioContainer.add(radio1);
        radioContainer.add(radio2);
        return radioContainer;
    }

    private JPanel getButtonContainer(){
        JPanel buttonContainer = new JPanel();
        buttonContainer.setMinimumSize(new Dimension((int) (windowSizeX_min*0.7), 0));
        buttonContainer.setOpaque(false);
        buttonContainer.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(1, 1, 1, 1);
        for(int i = 0; i < 8; i++){
            gbc.gridx = i;
            for(int j = 0; j < 6; j++){
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                if(buttonLayout[j][i] == null)
                    continue;
                JButton butt = new CalcButton(PanelSize.PanelButton.dim(), buttonLayout[j][i]);
                if(buttonLayout[j][i] == BLANK)
                    butt.setEnabled(false);
                if(buttonLayout[j][i] == CTRL_EQUALS)
                    gbc.gridheight = 2;
                if(buttonLayout[j][i] == DIGIT_0)
                    gbc.gridwidth = 2;
                gbc.gridy = j;
                buttonContainer.add(butt, gbc);
            }
        }
        return buttonContainer;
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
    public enum PanelSize{
        PanelOut((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.15)),
        PanelBinary((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.16)),
        PanelRadio((int) (windowSizeX_min*0.15), (int) (windowSizeY_min*0.2)),
        PanelButton((int) (windowSizeX_min*0.09), (int) (windowSizeY_min*0.065)),
        PanelBottom((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.43)),
        PanelSpacer(0, (int) (windowSizeY_min*0.03)),
        PanelSpacerB(0, (int) (windowSizeY_min*0.01));
        private final int size_x;
        private final int size_y;
        PanelSize(int x, int y){
            this.size_x = x;
            this.size_y = y;
        }
        public int x(){
            return this.size_x;
        }
        public int y(){
            return this.size_y;
        }
        public Dimension dim(){
            return new Dimension(this.size_x, this.size_y);
        }
    }
}

class CalcButton extends JButton {
    Color color1 = new Color(217, 228, 241);
    Color color2 = new Color(237, 244, 252);

    CalcButton(Dimension d, CalculatorButton cb) {
        this.setText(cb.label);
        this.setBorder(new RoundedBorder(5));
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp;
        gp = new GradientPaint(0, h, color2, 0, 0, color1);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
        super.paintComponent(g);
    }
}

class GradientPanel extends JPanel {
    Color color1 = new Color(217, 228, 241);
    Color color2 = new Color(237, 244, 252);
    private final Direction direction;
    public GradientPanel(Direction direction){
        this.direction = direction;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp;
        if(direction == Direction.topdown){
            gp = new GradientPaint(0, h, color2, 0, 0, color1);
        }else{
            gp = new GradientPaint(0, h, color1, 0, 0, color2);
        }

        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
    }
}

class RoundedBorder implements Border {

    private final int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(6, 6, 6, 6);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(
            Component c, Graphics g, int x, int y, int width, int height) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.DARK_GRAY);
        g2.drawRoundRect(
                x + 1, y + 1,
                width - 3, height - 3,
                radius, radius
        );
        g2.dispose();
    }

}


