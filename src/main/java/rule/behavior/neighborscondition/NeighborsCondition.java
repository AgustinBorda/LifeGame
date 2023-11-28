package rule.behavior.neighborscondition;

import cell.Cell;

public class NeighborsCondition {
    private final int desiredNeighbors;

    public NeighborsCondition(int n) {
        desiredNeighbors = n;
    }
    public boolean neighborsCondition(Cell c) {
        return c.numberOfAliveNeighbors() == desiredNeighbors;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NeighborsCondition) {
            return desiredNeighbors == ((NeighborsCondition) obj).desiredNeighbors;
        }
        return false;
    }
}
