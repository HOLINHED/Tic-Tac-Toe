package logic;

public abstract class Player {

    private char symbol;
    private Board board;

    Player(char symbol, Board board) {

        this.symbol = symbol;
        this.board = board;
    }

    abstract void makeMove();

    public char getSymbol() {
        return this.symbol;
    }

    protected Board getBoard() {
        return this.board;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }

}
