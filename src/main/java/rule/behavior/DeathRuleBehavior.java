package rule.behavior;

import cell.Cell;
import cell.DeadState;

public class DeathRuleBehavior implements RuleBehavior {

    @Override
    public final boolean canApply(Cell c) {
        return true;
    }

    @Override
    public final void apply(Cell c) {
        c.setNextState(new DeadState());
    }
}
