package rule;

import cell.Cell;
import rule.behavior.RuleBehavior;

public abstract class Rule {
    protected RuleBehavior behavior;

    public boolean canApply(Cell c) {
        return behavior.canApply(c);
    }

    public void apply(Cell c) {
        behavior.apply(c);
    }
}
