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
        final int size = state.length;

        int fToken = 0;
        int bToken = 0;

        for (int x = 0; x < state.length; x++) {

            int xToken = 0;
            int yToken = 0;

            // Checks diagonals
            if (state[x][x] == symbol) fToken += 1;

            final int r = (width - 1) - x;

            if (state[x][r] == symbol) bToken += x;

            // Checks rows/cols
            for (int y = 0; y < state[x].length; y++) {

                if (state[x][y] == symbol) yToken += 1;

                if (state[y][x] == symbol) xToken += 1;

                if (xToken == size || yToken == size || fToken == size || bToken == size) return true;
            }
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
