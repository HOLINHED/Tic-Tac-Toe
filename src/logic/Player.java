package logic;

public abstract class Player {

    private char symbol;
    private int score;
    private Board board;

    public Player(char symbol, Board board) {

        this.symbol = symbol;
        this.board = board;

        setScore(0);

    }

    public void setScore(int score) {
        this.score = score;
    }

    abstract void makeMove();

    protected char getSymbol() {
        return this.symbol;
    }

    protected Board getBoard() {
        return this.board;
    }

}
