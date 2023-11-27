package rule.behavior;

import cell.AliveState;
import cell.Cell;
import rule.behavior.cellcondition.CellCondition;
import rule.behavior.neighborscondition.NeighborsCondition;

public class LifeRuleBehavior implements RuleBehavior {
    CellCondition cellCondition;
    NeighborsCondition neighborsCondition;

    public LifeRuleBehavior(CellCondition c, NeighborsCondition n) {
        cellCondition = c;
        neighborsCondition = n;
    }

    @Override
    public boolean canApply(Cell c) {
        return cellCondition.cellCondition(c) && neighborsCondition.neighborsCondition(c);
    }

    @Override
    public void apply(Cell c) {
        c.setNextState(new AliveState());
    }
}
