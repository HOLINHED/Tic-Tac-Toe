package logic;

public class Computer extends Player{

    public Computer(Board board) {
        super('O', board);
    }

    public void makeMove() {

        final int x = (int) Math.floor(Math.random() * this.getBoard().getWidth());
        final int y = (int) Math.floor(Math.random() * this.getBoard().getHeight());

        this.getBoard().updateState(x, y, this.getSymbol());

    }
}
