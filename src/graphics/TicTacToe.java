package graphics;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.List;

import logic.Game;

public class TicTacToe extends JPanel {

    private Game game;
    private List<Tile> tiles;

    public TicTacToe() {
        setBackground(Color.black);

        this.game = new Game(3, new MouseInput());

        tiles = new ArrayList<>();

        int wh = game.getBoard().getHeight();

        for (int y = 0; y < wh; y++)
            for(int x = 0; x < wh; x++)
                tiles.add(new Tile(x, y, 600 / 3, game));

        ActionListener update = event -> repaint();

        Timer timer = new Timer(10, update);
        timer.start();
    }

    public void paintComponent(Graphics window) {

        super.paintComponent(window);

        if (game.isRunning()) {
            game.update();
        } else {
            //System.out.println(game.getWinner().getSymbol());
            //System.exit(0);
        }

        tiles.forEach(a -> a.draw(window));

    }

}
