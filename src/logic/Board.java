package logic;

import java.util.Arrays;

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

        Arrays.stream(this.state)
                .forEach(a -> Arrays.fill(a, ' '));

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
        return this.boardSize != this.width * this.height;
    }

    public boolean movePossible(int x, int y) {
        return (x >= 0 && y >= 0 && x < width && y < height) && this.state[x][y] == ' ';
    }

    public boolean checkWinner(char symbol) {

        // TODO: Use algorithm to check for a winner, and return that winner, else return '0'

        int token = 0;

        return token == 3;
    }

    @Override
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
