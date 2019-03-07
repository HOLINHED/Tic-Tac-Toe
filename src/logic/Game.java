package logic;

public class Game {

    private Board board;
    private Player user;
    private Player computer;
    private boolean running;

    public Game(int width, int height, Input input) {
        this.board = new Board(width, height);
        this.user = new User(board, input);
        this.computer = new Computer(board);

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
        this.computer.makeMove();

    }

    public boolean isRunning() {
        return this.running;
    }

}
