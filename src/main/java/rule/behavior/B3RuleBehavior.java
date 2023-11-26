package rule.behavior;

import cell.Cell;

public class B3RuleBehavior extends BirthRuleBehavior {
    @Override
    protected boolean neighborsCondition(Cell c) {
        return c.numberOfAliveNeighbors() == 3;
    }
}
