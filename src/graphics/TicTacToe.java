package graphics;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.Timer;

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
    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    public TicTacToe() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

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

        tiles.forEach(a -> a.draw(window));

        if (game.isRunning()) {
            game.update();
        } else {
            window.setColor(Color.red);

            window.setFont(new Font("TAHOMA", Font.BOLD, 40));

            final String winner = "WINNER: " + game.getWinner();

            final int w = window.getFontMetrics().stringWidth(winner);

            window.drawString(winner, w - w/6 - 5, 50);
            timer.stop();
        }
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
