package main.ui;

import main.ui.ui_elements.*;
import main.MenuAction;
import main.MenuController;
import main.ui.ui_elements.Menu;
import main.ui.ui_elements.MenuBar;

import javax.swing.*;
import java.awt.*;

import static main.ui.ui_elements.CalculatorButton.*;


public class UI extends JFrame{
    private static final int windowSizeX_min = 400;
    private static final int windowSizeY_min = 380;
    private final String title = "Calculator";
    private final String iconPath = "img/icon.png";
    public static Font regularFont = new Font("Segoe UI", Font.PLAIN, 10);
    public static Font semiboldFont = new Font("Segoe UI Semibold", Font.PLAIN, 10);

    private final String[] radioBases = {"Hex", "Dec", "Oct", "Bin"};
    private final String[] radioWordSizes = {"Qword", "Dword", "Word", "Byte"};
    private OutputPanel outputPanel;
    private BinaryPanel binaryPanel;
    private RadioPanel basePanel;
    private RadioPanel wordSizePanel;
    private ButtonPanel buttonContainer;
    public UI(){
        Dimension windowSize_min = new Dimension(windowSizeX_min, windowSizeY_min);
        this.setMinimumSize(windowSize_min);

        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());

        JMenuBar bar = new MenuBar();
        this.setJMenuBar(bar);

        JPanel bg = new GradientPanel(Direction.bottomup);
        bg.setLayout(new BorderLayout());
        bg.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.NORTH);
        bg.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);
        bg.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
        bg.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);

        this.outputPanel = new OutputPanel(PanelSize.PanelOut, Direction.topdown);
        this.binaryPanel = new BinaryPanel(PanelSize.PanelBinary, Direction.topdown);

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BorderLayout());

        JPanel mp = new JPanel();
        mp.setPreferredSize(new Dimension((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.35)));
        mp.setMaximumSize(new Dimension((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.35)));
        mp.setLayout(new BorderLayout(0, 5));
        mp.setOpaque(false);

        mp.add(this.outputPanel, BorderLayout.NORTH);
        mp.add(this.binaryPanel, BorderLayout.CENTER);

        content.add(mp, BorderLayout.NORTH);

        JPanel btp = new JPanel();
        btp.setOpaque(false);
        btp.setLayout(new BorderLayout());

        JPanel radioContainer = new JPanel();
        radioContainer.setLayout(new GridLayout(2,1));
        radioContainer.setPreferredSize(new Dimension((int) (windowSizeX_min*0.15), 0));
        radioContainer.setOpaque(false);
        basePanel = new RadioPanel(PanelSize.PanelRadio, Direction.topdown, radioBases, "Dec");
        wordSizePanel = new RadioPanel(PanelSize.PanelRadio, Direction.topdown, radioWordSizes, "Qword");
        radioContainer.add(basePanel);
        radioContainer.add(wordSizePanel);

        btp.add(radioContainer, BorderLayout.WEST);
        buttonContainer = new ButtonPanel(PanelSize.PanelButtonContainer);
        btp.add(buttonContainer, BorderLayout.CENTER);

        content.add(btp, BorderLayout.CENTER);
        bg.add(content, BorderLayout.CENTER);
        this.setResizable(false);
        this.add(bg);
        this.setTitle(title);
        this.setVisible(false);
    }
    public OutputPanel getOutputPanel(){
        return outputPanel;
    }
    public RadioPanel getBaseRadioPanel(){
        return basePanel;
    }
    public RadioPanel getWordSizePanel(){
        return  wordSizePanel;
    }
    public ButtonPanel getButtonContainer(){
        return buttonContainer;
    }
    public BinaryPanel getBinaryPanel() {
        return binaryPanel;
    }
    public enum Direction{
        topdown,
        bottomup
    }
    public enum PanelSize{
        PanelOut((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.15)),
        PanelBinary((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.16)),
        PanelRadio((int) (windowSizeX_min*0.15), (int) (windowSizeY_min*0.2)),
        PanelButton((int) (windowSizeX_min*0.09), (int) (windowSizeY_min*0.065)),
        PanelButtonContainer((int) (windowSizeX_min*0.7), 0),
        PanelBottom((int) (windowSizeX_min*0.9), (int) (windowSizeY_min*0.43)),
        QuartetPanel((int) (windowSizeX_min*0.2), (int) (windowSizeY_min*0.1)),
        OutputLabel((int)(windowSizeX_min*0.9), (int)(windowSizeY_min*0.05));
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


