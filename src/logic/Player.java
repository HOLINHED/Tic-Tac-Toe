package logic;

public abstract class Player {

    private char symbol;
    private Board board;

    /**
     * Class that all players extend. Contains that players symbol and it's board reference.
     *
     * @param symbol The symbol of this player.
     *
     * @param board This player's board reference.
     */
    Player(char symbol, Board board) {

        this.symbol = symbol;
        this.board = board;
    }

    /**
     * To be implemented in class that extends this one. Defines how a player makes
     * a move.
     */
    abstract void makeMove();

    /**
     * @return char Returns this player's symbol.
     */
    char getSymbol() {
        return this.symbol;
    }

    /**
     * @return Board Returns this player's board reference.
     */
    Board getBoard() {
        return this.board;
    }

    /**
     * @return String The player's symbol as a string.
     */
    @Override
    public String toString() {
        return Character.toString(symbol);
    }

}
