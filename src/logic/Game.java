package logic;

public class Game {

    private Board board;
    private Player user;
    private Player computer;
    private String winner;
    private boolean running;
    private boolean turn;

    /**
     * Manages the entire game. Creates both of the player instances, manages turns, and updates
     * board.
     *
     * @param size The size of the board to create.
     *
     * @param input The input system to use. This is how input gets from the player to the game.
     */
    public Game(int size, Input input) {

        // Creates board instance
        board = new Board(size);

        // Creates both players, both given a reference to board to access it's methods.
        // The user also gets a reference to the input system to use.
        user = new User(board, input);
        computer = new Computer(board);

        // Sets initial turn, if true, it's the users turn. If false, it's the computers turn.
        turn = true;

        // Sets running to true. Manages whether the game is not in a win/draw state.
        running = true;
    }

    /**
     * @return Board Reference to the board this game is currently using. This is helpful
     *               for drawing it's current state.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * The main loop for the game. Has each player take turns until there is a winner
     * or the board is in a draw state. When either condition is met, running is set
     * to false, and the game is no longer updated.
     */
    public void update() {

        // Checks for draw
        if (!board.playPossible()) {
            running = false;
            winner = "NONE";
            return;
        }

        // Get whatever player is supposed to be playing.
        Player playing = turn ? user : computer;

        // Gets board size of the board before the player makes a move.
        final int prevSize = getBoard().getBoardSize();

        // Player makes move.
        playing.makeMove();

        // Compares previous size to current size. If it isn't greater, then
        // the move the player was supposed to make was not valid, and they
        // have to go again.
        if (getBoard().getBoardSize() > prevSize)
            turn = !turn;

        // Checks for whether board is in a win state for current player.
        if (getBoard().checkWinner(playing)) {
            running = false;
            winner = playing.toString();
        }

    }

    /**
     * @return boolean Returns true if game is running. False otherwise.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * @return String returns the winner of this game.
     */
    public String getWinner() {
        return winner;
    }

}
