package rule;

import rule.behavior.RuleBehaviorFactory;

public class SurviveRule extends Rule {
    public SurviveRule(int neighbors) {
        behavior = RuleBehaviorFactory.makeSurviveRuleBehavior(neighbors);
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SurviveRule)
            return behavior.equals(((SurviveRule) obj).behavior);
        return false;
    }
}
