package cell;

import board.Board;

public class CellFactory {


    public static Cell makeAliveCell(Board b, int row, int column) {
        return new AliveCell(b, row, column);
    }

    public static Cell makeDeadCell(Board b, int row, int column) {
        return new DeadCell(b, row, column);
    }
}
