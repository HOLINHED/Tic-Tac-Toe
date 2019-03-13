package graphics;

import javax.swing.JFrame;

public class Runner extends JFrame {

    /**
     * This is the runner for the graphics version of the game. It
     * creates an instance of TicTacToe, which handles
     * all updates and drawing.
     */
    private Runner() {
        super("Tic Tac Toe");
        add(new TicTacToe());
        setResizable(false);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     *
     * @param args is not used
     */
    public static void main(String... args) {
        new Runner();
    }

}
