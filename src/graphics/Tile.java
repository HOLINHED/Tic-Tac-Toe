package graphics;

import java.awt.Graphics;
import java.awt.Color;

public class Tile {

    private static int scale;
    private int x;
    private int y;
    private char symbol;

    public Tile(int x, int y, int scl) {
        this.x = x;
        this.y = y;
        this.scale = scl;
    }

    public void draw(Graphics window) {

        window.setColor(Color.white);

        window.fillRect(this.x * scale, this.y * scale, scale - 1, scale - 1);

    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

}
