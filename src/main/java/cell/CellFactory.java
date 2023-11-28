package cell;

import board.Board;

public class CellFactory {

    private final Board b;
    private int row;

    private int column;

    public CellFactory(Board b) {
        this.b = b;
        row = 0;
        column = -1;
    }


    private Cell makeCell(CellState state) {
        column++;
        if(column >= b.getColumns()) {
            column = 0;
            row++;
        }
        return new Cell(b, state, row, column);
    }

    public Cell makeAliveCell() {
        return makeCell(AliveState.getInstance());
    }

    public Cell makeDeadCell() {
        return makeCell(DeadState.getInstance());
    }
}
