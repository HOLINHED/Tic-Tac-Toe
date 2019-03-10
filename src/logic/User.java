package logic;

public class User extends Player {

    private Input input;

    public User(Board board, Input input) {
        super('X', board);

        this.input = input;
    }

    public void makeMove() {

        int x;
        int y;

        do {
            input.getPos();

            x = input.getX();
            y = input.getY();

        } while (!this.getBoard().movePossible(x, y) && this.getBoard().playPossible());

        this.getBoard().updateState(x, y, this.getSymbol());

    }
}
