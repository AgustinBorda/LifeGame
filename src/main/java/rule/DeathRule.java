package rule;

import cell.Cell;
import cell.DeadState;

public class DeathRule implements Rule {

    public DeathRule() {}
    @Override
    public boolean canApply(Cell c) {
        return true;
    }

    @Override
    public void apply(Cell c) {
        c.setNextState(DeadState.getInstance());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DeathRule;
    }
}
