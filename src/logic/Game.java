package logic;

public class Game {

    private Board board;
    private Player user;
    private Player computer;
    private Player winner;
    private boolean running;

    public Game(int big, Input input) {
        this.board = new Board(big);

        this.user = new User(board, input);
        this.computer = new Computer(board);
        this.winner = null;

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

        this.user.makeMove();

        if (this.getBoard().checkWinner(this.user.getSymbol())) {
            this.running = false;
            this.winner = user;
            return;
        }

        this.computer.makeMove();

        if (this.getBoard().checkWinner(this.computer.getSymbol())) {
            this.running = false;
            this.winner = computer;
            return;
        }

    }

    public boolean isRunning() {
        return this.running;
    }

    public Player getWinner() {
        return this.winner;
    }

}
