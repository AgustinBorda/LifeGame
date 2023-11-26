package rule.behavior;

import cell.AliveState;
import cell.Cell;

public abstract class BirthRuleBehavior implements RuleBehavior {
    @Override
    public final boolean canApply(Cell c) {
        return c.isAlive() && neighborsCondition(c);
    }

    protected abstract boolean neighborsCondition(Cell c);

    @Override
    public final void apply(Cell c) {
        c.setNextState(new AliveState());
    }
}
