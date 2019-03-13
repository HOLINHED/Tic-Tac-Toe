package textBased;

import java.util.Scanner;
import logic.Input;

public class KeyInput implements Input {

    private int x;
    private int y;

    @Override
    public void getPos() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x pos: ");
        x = scanner.nextInt();

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
