package logic;

import java.util.Arrays;

public class Board {

    private int width;
    private int height;
    private char[][] state;
    private int boardSize;

    public Board(int big) {

        this.width = big;
        this.height = big;

        this.state = new char[this.width][this.height];
        this.boardSize = 0;

        Arrays.stream(this.state)
                .forEach(a -> Arrays.fill(a, ' '));
    }

    public void updateState(int x, int y, char symbol) {
        this.state[x][y] = symbol;
        this.boardSize += 1;
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

        // Check rows/cols
        for (int x = 0; x < state.length; x++) {
            int xToken = 0;
            int yToken = 0;

            for (int y = 0; y < state[x].length; y++) {
                if (state[x][y] == symbol) {
                    yToken++;
                }

                if (state[y][x] == symbol) {
                    xToken += 1;
                }

                if (xToken == 3 || yToken == 3) return true;
            }
        }

        int fToken = 0;
        int bToken = 0;
        
        for (int i = 0, j = this.width - 1; i < this.width && j >= 0; i++, j--) {
            if (state[i][i] == symbol) {
                fToken += 1;
            }

            if (state[j][j] == symbol) {
                bToken += 1;
            }

            if (fToken == 3 || bToken == 3) return true;
        }

        return false;
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