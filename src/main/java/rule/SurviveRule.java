package rule;

import cell.AliveState;
import cell.Cell;

public class SurviveRule implements Rule {
    private int neighbors;

    public SurviveRule(int neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean canApply(Cell c) {
        return c.isAlive() && c.numberOfAliveNeighbors() == neighbors;
    }

    @Override
    public void apply(Cell c) {
        c.setNextState(AliveState.getInstance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SurviveRule that = (SurviveRule) o;

        return neighbors == that.neighbors;
    }

    @Override
    public int hashCode() {
        return neighbors;
    }
}
