package graphics;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Polygon;

public class TicTacToe extends Canvas {

    public TicTacToe() {
        setBackground(Color.white);
    }

    @Override
    public void paint(Graphics window) {

        window.setColor(Color.red);
        window.drawString("Hello world!", 50, 50);

    }



}
