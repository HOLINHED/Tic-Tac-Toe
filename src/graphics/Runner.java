package graphics;

import javax.swing.JFrame;

public class Runner extends JFrame {

    private Runner() {
        super("Tic Tac Toe");
        add(new TicTacToe());
        setResizable(false);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String... args) {
        new Runner();
    }

}
