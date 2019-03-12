package graphics;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import logic.Game;

class Tile {

    private int scale;
    private int x;
    private int y;
    private Game game;

    Tile(int x, int y, int scale, Game context) {
        this.x = x;
        this.y = y;
        this.game = context;
        this.scale = scale;
    }

    void draw(Graphics window) {

        char symbol = game.getBoard().getState()[x][y];

        window.setColor(Color.white);

        window.fillRect(x * scale, y * scale, scale - 1, scale - 1);

        window.setColor(Color.black);

        window.setFont(new Font("TAHOMA", Font.BOLD, 150));

        window.drawString(Character.toString(symbol), (x * scale) + scale / 4, (y * scale) + (3 * scale) / 4);

    }

}
