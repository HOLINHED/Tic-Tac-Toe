package logic;

import java.util.Arrays;

public class Board {

    private int width;
    private int height;
    private char[][] state;
    private int boardSize;

    Board(int size) {

        width = size;
        height = size;

        state = new char[this.width][this.height];
        boardSize = 0;

        Arrays.stream(state)
                .forEach(a -> Arrays.fill(a, ' '));
    }

    void updateState(int x, int y, char symbol) {
        state[x][y] = symbol;
        boardSize += 1;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    boolean playPossible() {
        return boardSize < width * height;
    }

    boolean movePossible(int x, int y) {
        return (x >= 0 && y >= 0 && x < width && y < height) && state[x][y] == ' ';
    }

    boolean checkWinner(Player playing) {

        final char symbol = playing.getSymbol();

        // Check rows/cols
        for (int x = 0; x < state.length; x++) {
            int xToken = 0;
            int yToken = 0;

            for (int y = 0; y < state[x].length; y++) {
                if (state[x][y] == symbol) {
                    yToken += 1;
                }

                if (state[y][x] == symbol) {
                    xToken += 1;
                }

                if (xToken == 3 || yToken == 3) return true;
            }
        }

        // Check diagonals
        int fToken = 0;
        int bToken = 0;

        for (int i = 0; i < width; i++) {

            if (state[i][i] == symbol) {
                fToken += 1;
            }

            final int r = (width - 1) - i;
            if (state[i][r] == symbol) {
                bToken += 1;
            }

            if (fToken == 3 || bToken == 3) return true;
        }

        return false;
    }

    public char[][] getState() {
        return state;
    }

    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public String toString() {

        String board = "";

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board += " | " + state[x][y];
            }
            board += " |\n";
        }

        return board;
    }
}
