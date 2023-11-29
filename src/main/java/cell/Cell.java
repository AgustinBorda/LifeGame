package cell;

import board.Board;

public abstract class Cell {

    private Board board;
    private final int row;

    private final int column;

    public Cell(Board b, int i, int j) {
        if(i < 0 || i >= b.getRows() || j < 0 || j>= b.getColumns())
            throw new IllegalArgumentException("Invalid Cell position");
        board = b;
        row = i;
        column = j;
    }

    public Board getBoard() {
        return board;
    }

    public abstract boolean isAlive();

    public int numberOfAliveNeighbors() {
        return board.numberOfAliveNeighbors(this);
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cell) {
            Cell c = (Cell) obj;
            return isAlive() == c.isAlive();
        }
        return false;
    }
}
