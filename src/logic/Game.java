package logic;

public class Game {

    private Board board;
    private Player user;
    private Player computer;
    private Player winner;
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
        return this.board;
    }

    public void update() {

        if (!this.board.playPossible()) {
            this.running = false;
            return;
        }

        Player playing = turn ? user : computer;

        playing.makeMove();

        turn = !turn;

        if (getBoard().checkWinner(playing)) {
            running = false;
            winner = playing;
        }

    }

    public boolean isRunning() {
        return this.running;
    }

    public Player getWinner() {
        return this.winner;
    }

}
