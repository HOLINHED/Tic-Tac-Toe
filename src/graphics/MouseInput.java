package graphics;

import javax.swing.JPanel;

import logic.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements Input, MouseListener {

    private int x;
    private int y;
    private int size;

    MouseInput(int size, JPanel window) {
        this.size = size;

        this.x = -1;
        this.y = -1;

        window.addMouseListener(this);
    }

    @Override
    public void getPos() { }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {

            final int x = e.getX();
            final int y = e.getY();

            this.x = x / size;
            this.y = y / size;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }
}
