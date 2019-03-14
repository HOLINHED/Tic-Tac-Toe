package logic;

import java.util.Arrays;

public class Board {

    private int width;
    private int height;
    private char[][] state;
    private int boardSize;

    /**
     * This is the class that manages the current state of the board. This class
     * allows the game to update it's state, and check for winners.
     *
     * @param size
     */
    Board(int size) {

        // Tic tac toe boards are always the same size.
        width = size;
        height = size;

        // Creates initial state of board.
        state = new char[this.width][this.height];
        boardSize = 0;

        // Sets each spot of board to an empty character.
        Arrays.stream(state)
                .forEach(a -> Arrays.fill(a, ' '));
    }

    /**
     * Updates the state of the board to include the symbol at a specific spot.
     * also increments boardSize by one every time it's called to show that a
     * spot was taken up.
     *
     * @param x The X position to update
     *
     * @param y The Y position to update
     *
     * @param symbol The symbol to be placed at the spot.
     */
    void updateState(int x, int y, char symbol) {
        state[x][y] = symbol;
        boardSize += 1;
    }

    /**
     * @return int The width of the board.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return int The height of the current board.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return boolean Returns true if board is not full. False otherwise.
     */
    boolean playPossible() {
        return boardSize < width * height;
    }

    /**
     * This methods checks whether a specific move is legal. A move is legal when X/Y
     * are above 0 and below width/height AND the symbol at that position is NOT a player.
     *
     * @param x The X component of the position to check.
     *
     * @param y The Y component of the position to check.
     *
     * @return boolean Returns true if a move to that position is legal. False otherwise.
     */
    boolean movePossible(int x, int y) {
        return (x >= 0 && y >= 0 && x < width && y < height) && state[x][y] == ' ';
    }

    /**
     * Checks if the board is in a winning state for a specific symbol. Checks rows, columns, and both
     * diagonals.
     *
     * @param symbol The player getting checks. The method gets the symbol of this player.
     *
     * @return boolean Returns true if board is in a winning state. False otherwise.
     */
    boolean checkWinner(char symbol) {

        // stores the symbol for cleaner code
        final int size = state.length;

        // Does not reset because there is only 1 set of each diagonal.
        int fToken = 0;
        int bToken = 0;

        for (int x = 0; x < state.length; x++) {

            // Resets token on each iteration because there are N amount of
            // rows and cols.
            int xToken = 0;
            int yToken = 0;

            // Forward diagonal
            if (state[x][x] == symbol) fToken += 1;

            // Inverse direction of diagonal 0 -> size, 0 <- size
            final int r = (width - 1) - x;

            // Backwards diagonal
            if (state[x][r] == symbol) bToken += 1;

            // Checks rows/cols
            for (int y = 0; y < state[x].length; y++) {

                // Column
                if (state[x][y] == symbol) yToken += 1;

                // Row
                if (state[y][x] == symbol) xToken += 1;

                // If any token is equal to size, then board is in a win state.
                if (xToken == size || yToken == size || fToken == size || bToken == size) return true;
            }
        }

        return false;
    }

    /**
     * @return char[][] The current state of the board.
     */
    public char[][] getState() {
        return state;
    }

    /**
     * @return The current board size. Which is how many moves have been made
     *         onto the board.
     */
    int getBoardSize() {
        return boardSize;
    }

    /**
     * Creates a visualization of the current board state, mostly for use for debugging.
     *
     * @return String The current state of the board represented as a string.
     */
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
