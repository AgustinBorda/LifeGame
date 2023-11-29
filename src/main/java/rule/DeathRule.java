package rule;

import cell.Cell;
import cell.CellFactory;

public class DeathRule implements Rule {

    public DeathRule() {}
    @Override
    public boolean canApply(Cell c) {
        return true;
    }

    @Override
    public Cell apply(Cell c) {
        return CellFactory.makeDeadCell(c.getBoard(), c.getRow(), c.getColumn());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DeathRule;
    }
}
