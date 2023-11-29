package rule;

import cell.Cell;
import cell.CellFactory;

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
    public Cell apply(Cell c) {
        return CellFactory.makeAliveCell(c.getBoard(), c.getRow(),c.getColumn());
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
