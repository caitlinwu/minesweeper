package minesweeper;

import javax.swing.JFrame;

import ui.Field;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Field f = new Field();
        f.setField(24, 24, 99);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(f);
        frame.pack();
    }

    /*
    public static void main(String[] args) {
        Field field = new Field();
        field.setField(2, 2, 0);
        Scanner scan = new Scanner(System.in);
        field.print();
        while (true) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            int flag = scan.nextInt();
            if (flag == 0) field.click(row, col);
            else field.flag(row, col);
            field.print();
        }
    }
     */
}
