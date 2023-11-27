package rule.behavior;

import rule.behavior.cellcondition.AliveCellCondition;
import rule.behavior.cellcondition.DeadCellCondition;
import rule.behavior.neighborscondition.NeighborsCondition;

public class RuleBehaviorFactory {
    public static RuleBehavior makeDeadthRuleBehavior() {
        return new DeathRuleBehavior();
    }

    public static RuleBehavior makeBirthRuleBehavior(int neighbors) {
        return new LifeRuleBehavior(new DeadCellCondition(), new NeighborsCondition(neighbors));
    }

    public static RuleBehavior makeSurviveRuleBehavior(int neighbors) {
        return new LifeRuleBehavior(new AliveCellCondition(), new NeighborsCondition(neighbors));
    }
}
