package rule.behavior;

import cell.Cell;

public class S3RuleBehavior extends SurviveRuleBehavior {
    @Override
    protected boolean neighborsCondition(Cell c) {
        return c.numberOfAliveNeighbors() == 3;
    }
}
