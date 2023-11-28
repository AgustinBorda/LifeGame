package rule.behavior.cellcondition;

import cell.Cell;

public class DeadCellCondition implements CellCondition {

    public DeadCellCondition() {}
    @Override
    public boolean cellCondition(Cell c) {
        return !c.isAlive();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DeadCellCondition;
    }
}
