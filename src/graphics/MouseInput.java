package graphics;

import logic.Input;

public class MouseInput implements Input {

    // Make this get position of mouse to get the x and y

    public int getX() {
        return (int) Math.floor(Math.random() * 3);
    }

    public int getY() {
        return (int) Math.floor(Math.random() * 3);
    }

}
