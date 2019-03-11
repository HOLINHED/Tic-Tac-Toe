package graphics;

import logic.Input;

public class MouseInput implements Input {

    private int x;
    private int y;
    private int size;

    MouseInput(int size) {
        this.size = size;

        this.x = 0;
        this.y = 0;
    }

    @Override
    public void getPos() {
        x = (int) Math.floor(Math.random() * 600) / size;
        y = (int) Math.floor(Math.random() * 600) / size;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
