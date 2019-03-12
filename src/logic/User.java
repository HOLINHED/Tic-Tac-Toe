package logic;

public class User extends Player {

    private Input input;

    public User(Board board, Input input) {
        super('X', board);

        this.input = input;
    }

    public void makeMove() {

        input.getPos();

        final Board board = getBoard();

        int x = input.getX();
        int y = input.getY();

        if (board.movePossible(x, y) && board.playPossible()) {
            board.updateState(x, y, getSymbol());
        }

    }
}
