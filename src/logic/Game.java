package logic;

public class Game {

    private Board board;
    private Player user;
    private Player computer;
    private String winner;
    private boolean running;
    private boolean turn;

    public Game(int big, Input input) {
        this.board = new Board(big);

        this.user = new User(board, input);
        this.computer = new Computer(board);
        this.winner = null;
        this.turn = true;

        this.running = true;
    }

    public Board getBoard() {
        return board;
    }

    public void update() {

        if (!board.playPossible()) {
            running = false;
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
