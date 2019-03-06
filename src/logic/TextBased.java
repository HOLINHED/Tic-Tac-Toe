package logic;

public class TextBased {

    public static void main(String[] args) {

        Game game = new Game();

        System.out.println(game.getBoard());

        while(game.isRunning()) {

            game.update();

            System.out.println(game.getBoard());

        }

    }

}
