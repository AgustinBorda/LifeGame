package board;

import cell.Cell;

import java.util.Iterator;

public class BoardIterator implements Iterator<Cell> {
    private final Board b;

    private int currentRow;

    private int currentColumn;
    public BoardIterator(Board b) {
        this.b = b;
        currentRow = 0;
        currentColumn = -1;
    }

    @Override
    public boolean hasNext() {
        return currentRow < b.getRows()-1 || currentColumn < b.getColumns()-1;
    }

    @Override
    public Cell next() {
        currentColumn++;
        if(currentColumn >= b.getColumns()) {
            currentColumn = 0;
            currentRow++;
        }
        return b.getCell(currentRow, currentColumn);
    }
}
