package textBased;

import java.util.Scanner;
import logic.Input;

public class KeyInput implements Input {

    private int x;
    private int y;

    public void getPos() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x pos: ");
        x = scanner.nextInt();

        System.out.print("Enter y pos: ");
        y = scanner.nextInt();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
