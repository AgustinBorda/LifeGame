package rule.behavior.cellcondition;

import cell.Cell;

public class AliveCellCondition implements CellCondition {

    public AliveCellCondition() {}
    @Override
    public boolean cellCondition(Cell c) {
        return c.isAlive();
    }
}
