package graphics;

import javax.swing.JFrame;
import java.awt.*;

public class Runner extends JFrame {

    final int WIDTH = 600;
    final int HEIGHT = 600;

    public static void main(String[] args) {
        new Runner();
    }

    private Runner() {
        super("Tic Tac Toe");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        getContentPane().add(new TicTacToe());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

}
