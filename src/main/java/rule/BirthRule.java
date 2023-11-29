package rule;

import cell.AliveState;
import cell.Cell;

public class BirthRule implements Rule {

    private int neighbors;

    public BirthRule(int neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean canApply(Cell c) {
        return !c.isAlive() && c.numberOfAliveNeighbors() == neighbors;
    }

    @Override
    public void apply(Cell c) {
        c.setNextState(AliveState.getInstance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirthRule birthRule = (BirthRule) o;

        return neighbors == birthRule.neighbors;
    }

    @Override
    public int hashCode() {
        return neighbors;
    }
}
