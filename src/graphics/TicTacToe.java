package graphics;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Dimension;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import logic.Game;

public class TicTacToe extends JPanel implements MouseListener {

    private Game game;
    private List<Tile> tiles;
    private Timer timer;
    private MouseInput input;

    public TicTacToe() {

        setPreferredSize(new Dimension(600, 600));

        setBackground(Color.black);

        final int BOARD_SIZE = 3;

        input = new MouseInput(600 / BOARD_SIZE);

        this.game = new Game(BOARD_SIZE, input);

        tiles = new ArrayList<>();

        int wh = game.getBoard().getHeight();

        for (int y = 0; y < wh; y++)
            for(int x = 0; x < wh; x++)
                tiles.add(new Tile(x, y, 600 / BOARD_SIZE, game));

        ActionListener update = event -> repaint();

        timer = new Timer(1, update);
        timer.start();

        addMouseListener(this);
    }

    public void paintComponent(Graphics window) {

        super.paintComponent(window);

        if (game.isRunning()) {
            game.update();
        } else {
            // TODO: Make this display in gui instead of in console.
            System.out.println(game.getWinner());
            timer.stop();
        }

        tiles.forEach(a -> a.draw(window));

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {

            final int x = e.getX();
            final int y = e.getY();

            input.setX(x);
            input.setY(y);

        }

    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }
}
