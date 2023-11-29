package board;

import cell.Cell;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class ToroidalBoard extends Board {
    public ToroidalBoard(String initialState, List<Rule> rules) {
        super(initialState, rules);
    }

    private int modulo(int a, int b) {
        return (a%b+b)%b;
    }

    @Override
    protected List<Cell> neighbors(int row, int column) {
        List<Cell> result = new ArrayList<>();
        result.add(board[modulo(row-1,getRows())][column]);
        result.add(board[row][modulo(column-1, getColumns())]);
        result.add(board[modulo(row+1,getRows())][column]);
        result.add(board[row][modulo(column+1, getColumns())]);
        result.add(board[modulo(row-1,getRows())][modulo(column-1, getColumns())]);
        result.add(board[modulo(row+1,getRows())][modulo(column-1, getColumns())]);
        result.add(board[modulo(row-1,getRows())][modulo(column+1, getColumns())]);
        result.add(board[modulo(row+1,getRows())][modulo(column+1, getColumns())]);
        return result;
    }
}
