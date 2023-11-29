package cell;

import board.Board;

public class AliveCell extends Cell {
    public AliveCell(Board b, int i, int j) {
        super(b, i, j);
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public String toString() {
        return "A";
    }
}
