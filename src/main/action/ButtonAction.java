package main.action;

public class ButtonAction {

    public final String label;
    public final Runnable action;

    public ButtonAction(String label, Runnable action) {
        this.label = label;
        this.action = action;
    }
}

