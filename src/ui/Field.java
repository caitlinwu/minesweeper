package ui;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    private ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();

    private Random r = new Random();  // TODO seed
    private int clicks = 0;
    private int bombs = 0;
    private int height = 0;
    private int width = 0;

    public Field() {

    }

    public void setField(int height, int width, int bombs) {
        clicks = 0;
        this.bombs = bombs;
        this.height = height;
        this.width = width;
        for (int i = 0; i < height; i++) {
            ArrayList<Tile> temps = new ArrayList<Tile>();
            for (int j =0; j< width; j++) {
                temps.add(new Tile());
            }
            tiles.add(temps);
        }

        if (bombs > height * width) bombs = (int) (height * width * 0.1);

        for (int i = 0; i < bombs; i++) {

            while (true) {
                int row = r.nextInt(height);
                int col = r.nextInt(width);

                if (tiles.get(row).get(col).getState() == -1) continue;

                tiles.get(row).get(col).setState(-1);
                int sRow = row - 1;
                if (sRow < 0) sRow = 0;
                int sCol = col - 1;
                if (sCol < 0) sCol = 0;

                int eRow = Math.min(height, row + 2);
                int eCol = Math.min(width, col + 2);

                for (int a = sRow; a < eRow; a++) {
                    for (int b = sCol; b < eCol; b++) {
                        if (tiles.get(a).get(b).getState() == -1) continue;
                        int val = tiles.get(a).get(b).getState();
                        tiles.get(a).get(b).setState(val + 1);
                    }
                }
                break;
            }
        }
    }
    public void click(int x, int y) {
        clickhelper(x,y);
        if (tiles.get(x).get(y).getState() == -1) {
            System.out.println("you died");
        }
        if (clicks == height * width - bombs)
            System.out.println("win");
    }

    public void clickhelper(int x, int y) {
        if (tiles.get(x).get(y).isClicked()) return;

        tiles.get(x).get(y).click();
        clicks++;
        if (tiles.get(x).get(y).getState() == 0) {
            int sRow = x - 1;
            if (sRow < 0) sRow = 0;
            int sCol = y - 1;
            if (sCol < 0) sCol = 0;

            int eRow = Math.min(tiles.size(), x + 2);
            int eCol = Math.min(tiles.get(0).size(), y + 2);

            for (int a = sRow; a < eRow; a++) {
                for (int b = sCol; b < eCol; b++) {
                    if (tiles.get(a).get(b).isClicked()) continue;
                    clickhelper(a, b);
                }
            }
        }


    }

    public void flag(int a, int b) {

        tiles.get(a).get(b).flagState();
    }

    public void print() {
        for (ArrayList<Tile> ts : tiles) {
            for (Tile t : ts) {
                if (t.isClicked())
                    System.out.format("%2d,", t.getState());
                else if (t.isFlagged()) {
                    System.out.print(" F,");
                }
                else
                    System.out.print(" ?,");
            }
            System.out.println();
        }
    }
}

