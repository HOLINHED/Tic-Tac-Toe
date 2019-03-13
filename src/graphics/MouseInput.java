package graphics;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import logic.Input;

public class MouseInput implements Input, MouseListener {

    private int x;
    private int y;
    private int size;

    /**
     * This is the input system for the graphics version of the game. It creates
     * a mouse listener and updates x and y positions every time it is clicked.
     * the default getPos() method is not used. Every MouseListener method except
     * for mouseClicked() is not needed.
     *
     * @param size The size of each tile
     *
     * @param window The window that the program should listen for mouse events
     *               in.
     */
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

        // Only updates if LEFT mouse button is clicked.
        if (e.getButton() == MouseEvent.BUTTON1) {

            final int x = e.getX();
            final int y = e.getY();

            // Converts to position in game state. This is done by taking current X/Y
            // position and dividing by size of each tile.
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
