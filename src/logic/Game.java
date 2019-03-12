package logic;

public class Game {

    private Board board;
    private Player user;
    private Player computer;
    private String winner;
    private boolean running;
    private boolean turn;

    public Game(int size, Input input) {
        board = new Board(size);

        user = new User(board, input);
        computer = new Computer(board);
        turn = true;

        running = true;
    }

    public Board getBoard() {
        return board;
    }

    public void update() {

        if (!board.playPossible()) {
            running = false;
            winner = "NONE";
            return;
        }

        Player playing = turn ? user : computer;

        final int prevSize = getBoard().getBoardSize();

        playing.makeMove();

        if (getBoard().getBoardSize() > prevSize)
            turn = !turn;

        if (getBoard().checkWinner(playing)) {
            running = false;
            winner = playing.toString();
        }

    }

    public boolean isRunning() {
        return running;
    }

    public String getWinner() {
        return winner;
    }

}
