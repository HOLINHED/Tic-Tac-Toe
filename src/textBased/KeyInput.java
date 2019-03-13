package textBased;

import java.util.Scanner;
import logic.Input;

public class KeyInput implements Input {

    private int x;
    private int y;

    /**
     * This is the input system for the text-based version of the game. It uses
     * Scanner to get input from the user. It does NOT have any checks for inputs.
     */
    KeyInput() {
        x = -1;
        y = -1;
    }

    @Override
    public void getPos() {

        // Creates scanner instance
        Scanner scanner = new Scanner(System.in);

        // TODO: Check to make sure user entered an integer

        // Get x position
        System.out.print("Enter x pos: ");
        x = scanner.nextInt();

        // Get y position
        System.out.print("Enter y pos: ");
        y = scanner.nextInt();
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
