package ui;

import java.awt.Dimension;

import javax.swing.JButton;

public class Tile extends JButton{
    private int state = 0;
    private boolean clicked = false;
    private boolean flagged = false;

    public Tile() {
        super();
        setPreferredSize(new Dimension(50, 50));
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void click() {
        if (!flagged) {
            clicked = true;
            setText(Integer.toString(state));
        }

    }

    public void flagState() {
        if(!clicked) {
            flagged = !flagged;
            if (flagged) setText("f");
            else setText("");
        }
    }

    public boolean isDead() {
        return state == -1 && clicked;
    }

    public boolean isClicked() {
        return clicked;
    }

    public boolean isFlagged() {
        return flagged;
    }
}
