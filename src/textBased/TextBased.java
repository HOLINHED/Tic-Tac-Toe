package textBased;

import logic.Game;

public class TextBased {

    /**
     * This is the runner for the text based version of the game.
     * it uses KeyInput for input from user, which uses Scanner
     * to get information from the keyboard.
     *
     * @param args is not used
     */
    public static void main(String... args) {

        // Initializing a 3x3 board game.
        Game game = new Game(3, new KeyInput());

        // Shows initial state of the board.
        System.out.println(game.getBoard());

        // Main update loop
        while(game.isRunning()) {

            // Updates game by playing both players turns
            game.update();

            // Shows updated state of the board
            System.out.println(game.getBoard());

        }

        // Display winner
        System.out.println("WINNER: " + game.getWinner().getSymbol());

    }

}
