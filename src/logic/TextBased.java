package logic;

public class TextBased {

    public static void main(String[] args) {

        Input input = new KeyInput();

        Game game = new Game(input);

        System.out.println(game.getBoard());

        while(game.isRunning()) {

            game.update();

            System.out.println(game.getBoard());

        }

    }

}
