package rule.behavior;

import cell.AliveState;
import cell.Cell;
import rule.behavior.RuleBehavior;

public abstract class SurviveRuleBehavior implements RuleBehavior {

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
