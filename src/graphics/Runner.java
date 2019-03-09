package graphics;

import javax.swing.JFrame;

public class Runner extends JFrame {

    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    public Runner() {

        super("Tic Tac Toe");
        setSize(this.WIDTH, this.HEIGHT);

        getContentPane().add(new TicTacToe());

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String... args) {
        Runner game = new Runner();
    }

}
