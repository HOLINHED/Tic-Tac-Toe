package graphics;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import logic.Game;

public class Tile {

    private static int scale;
    private int x;
    private int y;
    private char symbol;
    private Game game;

    public Tile(int x, int y, int scl, Game context) {
        this.x = x;
        this.y = y;
        this.game = context;
        this.scale = scl;
    }

    public void draw(Graphics window) {

        symbol = game.getBoard().getState()[x][y];

        window.setColor(Color.white);

        window.fillRect(x * scale, y * scale, scale - 1, scale - 1);

        window.setColor(Color.black);

        window.setFont(new Font("TAHOMA", Font.BOLD, 150));

        window.drawString(Character.toString(symbol), (x * scale) + scale / 2 - scale / 4, (y * scale) + scale / 2 + scale / 4);

    }

}
