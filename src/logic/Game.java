package logic;

public class Game {

    private Board board;
    private Player user;
    private Player computer;
    private boolean running;

    public Game() {
        this.board = new Board(3,3);
        this.user = new User(board);
        this.computer = new Computer(board);

        this.running = true;
    }

    public Board getBoard() {
        return this.board;
    }

    public void update() {

        this.user.makeMove();
        this.computer.makeMove();

    }

    public boolean isRunning() {
        return this.running;
    }

}
