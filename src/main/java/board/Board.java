package board;

import cell.Cell;
import cell.CellFactory;
import view.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Board extends Observable {
    protected Cell[][] board;

    private final int rows;

    private final int columns;

    public Board(String initialState) {
        CellFactory factory = new CellFactory(this);
        String[] lines = initialState.split("\n");
        rows = lines.length;
        columns = lines[0].length();
        board = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            if(lines[i].length() != columns)
                throw new IllegalArgumentException("The board must be rectangular");
            for (int j = 0; j< columns; j++) {
                if(lines[i].charAt(j) == ' ')
                    board[i][j] = factory.makeDeadCell();
                else
                    board[i][j] = factory.makeAliveCell();
            }
        }
    }


    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    protected abstract List<Cell> neighbors(int row, int column);

    public int numberOfAliveNeighbors(Cell c) {
        return (int)neighbors(c.getRow(), c.getColumn()).stream()
                .filter(Cell::isAlive).count();
    }

    protected Cell getCell(int row, int column) {
        return board[row][column];
    }


    public void transition() {
        BoardIterator iterator = iterator();
        while(iterator.hasNext())
            iterator.next().transition();
        notifyObservers();
    }

    public BoardIterator iterator() {
        return new BoardIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                res.append(board[i][j].toString());
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Board) {
            Board b = (Board) obj;
            if(b.getRows() != getRows())
                return false;
            if(b.getColumns() != getColumns())
                return false;
            BoardIterator thisIt = iterator();
            BoardIterator objIt = b.iterator();
            while(thisIt.hasNext()) {
                if(!thisIt.next().equals(objIt.next()))
                    return false;
            }
            return true;
        }
        return false;
    }
}
