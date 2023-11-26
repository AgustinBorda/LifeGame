package board;

import cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class FiniteBoard extends Board {
    public FiniteBoard(String initialState) {
        super(initialState);
    }

    @Override
    protected List<Cell> neighbors(int row, int column) {
        List<Cell> result = new ArrayList<>();
        if(row > 0)
            result.add(board[row-1][column]);
        if(column > 0)
            result.add(board[row][column-1]);
        if(row < getRows()-1)
            result.add(board[row+1][column]);
        if(column < getColumns()-1)
            result.add(board[row][column+1]);
        if(row > 0 && column > 0)
            result.add(board[row-1][column-1]);
        if(row < getRows()-1 && column > 0)
            result.add(board[row+1][column-1]);
        if(row > 0 && column < getColumns()-1)
            result.add(board[row-1][column+1]);
        if(row < getRows()-1 && column < getColumns()-1)
            result.add(board[row+1][column+1]);
        return result;
    }
}
