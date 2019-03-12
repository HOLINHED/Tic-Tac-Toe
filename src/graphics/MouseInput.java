package graphics;

import logic.Input;

public class MouseInput implements Input {

    private int x;
    private int y;
    private static int size;

    MouseInput(int size) {
        this.size = size;

        this.x = -1;
        this.y = -1;
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

    void setX(int x) {
        this.x = x / size;
        System.out.println(this.x);
    }

    void setY(int y) {
        this.y = y / size;
        System.out.println(this.y);
    }
}
