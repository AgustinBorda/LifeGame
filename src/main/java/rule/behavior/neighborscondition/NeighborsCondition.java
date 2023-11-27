package rule.behavior.neighborscondition;

import cell.Cell;

public class NeighborsCondition {
    int desiredNeighbors;

    public NeighborsCondition(int n) {
        desiredNeighbors = n;
    }
    public boolean neighborsCondition(Cell c) {
        return c.numberOfAliveNeighbors() == desiredNeighbors;
    }
}
