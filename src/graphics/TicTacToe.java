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
    private final int SIZE = 600;

    TicTacToe() {

        // Sets preferred within this component to avoid certain elements
        // going outside of the screen.
        setPreferredSize(new Dimension(SIZE, SIZE));

        setBackground(Color.black);

        // Size of the board
        final int BOARD_SIZE = 3;

        // Creates new game instance
        this.game = new Game(BOARD_SIZE, new MouseInput(SIZE / BOARD_SIZE, this));

        // Declares arraylist of tiles
        tiles = new ArrayList<>();

        int wh = game.getBoard().getHeight();

        // Adds as many tiles as the size of the game board. Uses only height of board
        // because the width and height are always the same.
        for (int y = 0; y < wh; y++)
            for(int x = 0; x < wh; x++)
                tiles.add(new Tile(x, y, SIZE / BOARD_SIZE, game));

        // Creates timer and update event to redraw the game if anything changes.
        ActionListener update = event -> repaint();

        timer = new Timer(1, update);
        timer.start();
    }

    public void paintComponent(Graphics window) {

        super.paintComponent(window);

        // Draws each tile
        tiles.forEach(a -> a.draw(window));

        // Updates game if it's running, else displays winner and stops timer
        // to avoid repainting when game is in it's final state.
        if (game.isRunning()) {
            game.update();
        } else {
            window.setColor(Color.red);

            window.setFont(new Font("TAHOMA", Font.BOLD, 40));

            final String winner = "WINNER: " + game.getWinner();

            final int w = window.getFontMetrics().stringWidth(winner);

            window.drawString(winner, (SIZE / 2) - (w / 2), 50);

            timer.stop();
        }
    }

}
