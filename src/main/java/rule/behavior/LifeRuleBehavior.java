package rule.behavior;

import cell.AliveState;
import cell.Cell;
import rule.behavior.cellcondition.CellCondition;
import rule.behavior.neighborscondition.NeighborsCondition;

import java.util.Objects;

public class LifeRuleBehavior implements RuleBehavior {
    private CellCondition cellCondition;
    private NeighborsCondition neighborsCondition;

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

    @Override
    public boolean equals(Object o) {
        if(o instanceof LifeRuleBehavior) {
            LifeRuleBehavior that = (LifeRuleBehavior) o;
            return cellCondition.equals(that.cellCondition) && neighborsCondition.equals(that.neighborsCondition);
        }
        return false;
    }

}
