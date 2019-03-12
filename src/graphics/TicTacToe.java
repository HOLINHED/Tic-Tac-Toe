package graphics;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;

import logic.Game;

public class TicTacToe extends JPanel {

    private Game game;
    private List<Tile> tiles;
    private Timer timer;
    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    TicTacToe() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        setBackground(Color.black);

        final int BOARD_SIZE = 3;

        this.game = new Game(BOARD_SIZE, new MouseInput(600 / BOARD_SIZE, this));

        tiles = new ArrayList<>();

        int wh = game.getBoard().getHeight();

        for (int y = 0; y < wh; y++)
            for(int x = 0; x < wh; x++)
                tiles.add(new Tile(x, y, 600 / BOARD_SIZE, game));

        ActionListener update = event -> repaint();

        timer = new Timer(1, update);
        timer.start();
    }

    public void paintComponent(Graphics window) {

        super.paintComponent(window);

        tiles.forEach(a -> a.draw(window));

        if (game.isRunning()) {
            game.update();
        } else {
            window.setColor(Color.red);

            window.setFont(new Font("TAHOMA", Font.BOLD, 40));

            final String winner = "WINNER: " + game.getWinner();

            final int w = window.getFontMetrics().stringWidth(winner);

            window.drawString(winner, (WIDTH / 2) - (w / 2), 50);
            timer.stop();
        }
    }

}
