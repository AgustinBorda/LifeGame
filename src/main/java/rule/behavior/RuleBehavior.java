package rule.behavior;

import cell.Cell;

public interface RuleBehavior {
    boolean canApply(Cell c);

    void apply(Cell c);
}
