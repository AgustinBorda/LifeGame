package rule.behavior;

import cell.Cell;

public class S2RuleBehavior extends SurviveRuleBehavior {
    @Override
    protected boolean neighborsCondition(Cell c) {
        return c.numberOfAliveNeighbors() == 2;
    }
}
