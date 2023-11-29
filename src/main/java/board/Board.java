package board;

import cell.Cell;
import cell.CellFactory;
import rule.Rule;
import view.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {

    protected Cell[][] board;

    private List<Rule> rules;

    private final int rows;

    private final int columns;

    public Board(String initialState, List<Rule> rules) {
        this.rules = rules;
        String[] lines = initialState.split("\n");
        rows = lines.length;
        columns = lines[0].length();
        board = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            if(lines[i].length() != columns)
                throw new IllegalArgumentException("The board must be rectangular");
            for (int j = 0; j< columns; j++) {
                if(lines[i].charAt(j) == ' ')
                    board[i][j] = CellFactory.makeDeadCell(this, i, j);
                else
                    board[i][j] = CellFactory.makeAliveCell(this, i, j);
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


    public void nextState() {
        Cell[][] newBoard = new Cell[rows][columns];
        BoardIterator boardIterator = iterator();
        while(boardIterator.hasNext()) {
            Cell c = boardIterator.next();
            for(Rule r: rules) {
                if (r.canApply(c)) {
                    newBoard[c.getRow()][c.getColumn()] = r.apply(c);
                    break;
                }
            }
        }
        board = newBoard;
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
