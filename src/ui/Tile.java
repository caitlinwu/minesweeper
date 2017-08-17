package ui;

import javax.swing.JButton;

public class Tile extends JButton{
    private int state = 0;
    private boolean clicked = false;
    private boolean flagged = false;

    public Tile() {
        super();
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void click() {
        if (!flagged) clicked = true;
    }

    public void flagState() {
        if(!clicked) flagged = !flagged;
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
