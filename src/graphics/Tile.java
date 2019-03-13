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

    /**
     * The tile class is each tile that is drawn. It displays
     * the current symbol in that specific spot on the board.
     *
     * @param x X position of game board that this tile represents
     *
     * @param y Y position of the board that this tile represents
     *
     * @param scale The scale of each tile. To calculate this value, take SCREENSIZE / BOARDSIZE.
     *
     * @param context A reference to the game to get the symbol that is at this spot.
     */

    Tile(int x, int y, int scale, Game context) {
        this.x = x;
        this.y = y;
        this.game = context;
        this.scale = scale;
    }

    void draw(Graphics window) {

        // Gets symbol from game state.
        char symbol = game.getBoard().getState()[x][y];

        window.setColor(Color.white);

        // Converts it's position from board size to screen size. This is done by taking X/Y
        // position and multiplying by scale. WIDTH and HEIGHT of the rectangle are 1 pixel
        // scale to give them a black boarder.
        window.fillRect(x * scale, y * scale, scale - 1, scale - 1);

        window.setColor(Color.black);

        window.setFont(new Font("TAHOMA", Font.BOLD, 150));

        // Draws it's symbol in the center of the tile.
        window.drawString(Character.toString(symbol), (x * scale) + scale / 4, (y * scale) + (3 * scale) / 4);

    }

}
