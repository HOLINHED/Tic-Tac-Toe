package textBased;

import java.util.Scanner;
import logic.Input;

public class KeyInput implements Input {

    public int getX() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an X value: ");
        final int x = scanner.nextInt();

        return x;
    }

    public int getY() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Y value: ");
        final int y = scanner.nextInt();

        return y;

    }

}
