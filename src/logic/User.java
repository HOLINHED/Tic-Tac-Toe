package logic;

public class User extends Player {

    private Input input;

    public User(Board board, Input input) {
        super('X', board);

        this.input = input;
    }

    public void makeMove() {

        final int x = input.getX();
        final int y = input.getY();

        this.getBoard().updateState(x, y, this.getSymbol());

    }
}
