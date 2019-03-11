package graphics;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;

import logic.Game;

public class TicTacToe extends JPanel {

    private Game game;
    private List<Tile> tiles;
    private Timer timer;

    public TicTacToe() {

        setPreferredSize(new Dimension(600, 600));

        setBackground(Color.black);

        final int BOARD_SIZE = 3;

        this.game = new Game(BOARD_SIZE, new MouseInput(600 / BOARD_SIZE));

        tiles = new ArrayList<>();

        int wh = game.getBoard().getHeight();

        for (int y = 0; y < wh; y++)
            for(int x = 0; x < wh; x++)
                tiles.add(new Tile(x, y, 600 / BOARD_SIZE, game));

        ActionListener update = event -> repaint();

        timer = new Timer(10, update);
        timer.start();
    }

    public void paintComponent(Graphics window) {

        super.paintComponent(window);

        if (game.isRunning()) {
            game.update();
        } else {
            // TODO: Make this display in gui instead of in console.
            System.out.println(game.getWinner().getSymbol());
            timer.stop();
        }

        tiles.forEach(a -> a.draw(window));

    }

}
