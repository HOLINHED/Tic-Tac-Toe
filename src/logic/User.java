package logic;

public class User extends Player {

    private Input input;

    /**
     * This is the class for the user. It stores a reference to an input
     * system and uses that input system to get data from the player on
     * what move to make.
     *
     * @param board A reference to the board.
     *
     * @param input The input system to use.
     */
    public User(Board board, Input input) {

        // Calls super class (Player) to set symbol and board reference.
        super('X', board);

        // Set the input system.
        this.input = input;
    }

    /**
     *
     */
    @Override
    public void makeMove() {

        // Updates position in the input system
        input.getPos();

        // Stores a reference to make code look slightly better.
        final Board board = getBoard();

        // Gets both positions from the input system.
        int x = input.getX();
        int y = input.getY();

        // Makes the move if it is possible.
        if (board.movePossible(x, y) && board.playPossible()) {
            board.updateState(x, y, getSymbol());
        }

    }
}
