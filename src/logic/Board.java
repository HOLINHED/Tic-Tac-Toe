package logic;

public class Board {

    private int width;
    private int height;
    private char[][] state;
    private int boardSize;

    public Board(int width, int height) {

        this.width = width;
        this.height = height;

        this.state = new char[this.width][this.height];
        this.boardSize = 0;

    }

    public void updateState(int x, int y, char symbol) {
        this.state[x][y] = symbol;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean playPossible() {

        if (this.boardSize == this.width * this.height) return false;

        return true;
    }

    public char getWinner() {

        // TODO: Use algorithm to check for a winner, and return that winner, else return '0'

        return '0';
    }

    public String toString() {

        String board = "";

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                board += " | " + this.state[x][y];
            }
            board += " |\n";
        }

        return board;
    }
}
