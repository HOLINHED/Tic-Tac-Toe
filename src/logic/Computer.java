package logic;

public class Computer extends Player{

    public Computer(Board board) {
        super('O', board);
    }

    public void makeMove() {

        // TODO: Make this smarter. It should actually analyze the board to make sure it's not going to lose.

        int x;
        int y;

        do {
            x = (int) Math.floor(Math.random() * this.getBoard().getWidth());
            y = (int) Math.floor(Math.random() * this.getBoard().getHeight());

        } while (!this.getBoard().movePossible(x, y) && this.getBoard().playPossible());

        this.getBoard().updateState(x, y, this.getSymbol());

    }
}
