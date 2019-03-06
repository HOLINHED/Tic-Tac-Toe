package logic;

import java.util.Scanner;

public class User extends Player {

    public User(Board board) {
        super('X', board);
    }

    public void makeMove() {

        Input input = new Input();

        final int x = input.getX();
        final int y = input.getY();

        this.getBoard().updateState(x, y, this.getSymbol());

    }
}
