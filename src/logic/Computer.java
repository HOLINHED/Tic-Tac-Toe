package logic;

import java.util.Arrays;

public class Computer extends Player {

    /**
     * @param board This players reference to the board.
     */
    public Computer(Board board) {
        // calls super class (Player) to give pass computer's symbol and board reference
        super('O', board);
    }

    /**
     * The computer scans over the current board to make the best move. If if finds
     * a move that would instantly win the game for it, it will play that move. If
     * it finds a move that the player could play to win the game automatically,
     * it will play that. If it doesn't find any of those scenarios, it finds
     * the most valuable move it could possibly play.
     */
    public void makeMove() {

        // Initial position
        int px = 0;
        int py = 0;

        // Highest score
        int maxToken = 0;

        // Copy of board state to avoid modifying actual state
        char[][] board = Arrays.stream(getBoard().getState())
                .map(char[]::clone)
                .toArray(char[][]::new);

        // Check every spot of board copy
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {

                // ONLY do calculations if that move would be possible
                if (maxToken < 100 && getBoard().movePossible(x, y)) {

                    board[x][y] = getSymbol();

                    // Automatically make move if computer would win
                    if (getBoard().checkWinner(getSymbol(), board)) {
                        px = x;
                        py = y;
                        maxToken = 999;
                    }

                    // Find highest scoring move
                    int fToken = 0;
                    int bToken = 0;

                    for (int cx = 0; cx < board.length; cx++) {

                        // Resets token on each iteration because there are N amount of
                        // rows and cols.
                        int xToken = 0;
                        int yToken = 0;

                        // Forward diagonal
                        if (board[cx][cx] == getSymbol()) fToken += 1;

                        // Inverse direction of diagonal 0 -> size, 0 <- size
                        final int r = (board.length - 1) - cx;

                        // Backwards diagonal
                        if (board[cx][r] == getSymbol()) bToken += 1;

                        // Checks rows/cols
                        for (int cy = 0; cy < board[cx].length; cy++) {

                            // Column
                            if (board[cx][cy] == getSymbol()) yToken += 1;

                            // Row
                            if (board[cy][cx] == getSymbol()) xToken += 1;

                            // Finds biggest token
                            final int[] tokens = {xToken, yToken, fToken, bToken};
                            final int bigToken = Arrays.stream(tokens).max().getAsInt();

                            // If this token is bigger than the highest token, then this move is
                            // more valuable than the last one.
                            if (bigToken > maxToken) {
                                px = x;
                                py = y;
                                maxToken = bigToken;
                            }
                        }
                    }

                    // Sets spot to player to check if they're about to win
                    board[x][y] = 'X';

                    // automatically makes move to block player win
                    if (maxToken < 500 && getBoard().checkWinner('X', board)) {
                        px = x;
                        py = y;
                        maxToken = 499;
                    }

                    // Resets spot to
                    board[x][y] = ' ';
                }
            }
        }

        // Make the move
        this.getBoard().updateState(px, py, this.getSymbol());
    }
}
