package cell;

import board.Board;

public class Cell {

    private Board board;
    private CellState currentState;

    private CellState nextState;

    private final int row;

    private final int column;

    public Cell(Board b,CellState c, int i, int j) {
        currentState = c;
        board = b;
        row = i;
        column = j;
    }

    public void setNextState(CellState s) {
        nextState = s;
    }

    public void transition() {
        currentState = nextState;
    }

    public boolean isAlive() {
        return currentState.alive();
    }

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
    public String toString() {
        return currentState.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cell) {
            Cell c = (Cell) obj;
            return isAlive() == c.isAlive();
        }
        return false;
    }
}
