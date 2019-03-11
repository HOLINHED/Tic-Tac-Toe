package graphics;

import logic.Input;

public class MouseInput implements Input {

    private int x;
    private int y;
    private int size;

    public MouseInput(int size) {
        this.size = size;

        this.x = 0;
        this.y = 0;
    }

    @Override
    public void getPos() {
        x = (int) Math.floor(Math.random() * 3);
        y = (int) Math.floor(Math.random() * 3);
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
