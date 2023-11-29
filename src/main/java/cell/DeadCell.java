package cell;

import board.Board;

public class DeadCell extends Cell {
    public DeadCell(Board b, int i, int j) {
        super(b, i, j);
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "D";
    }
}
