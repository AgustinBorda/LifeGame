package rule;

import rule.behavior.RuleBehaviorFactory;

public class SurviveRule extends Rule {
    public SurviveRule(int neighbors) {
        behavior = RuleBehaviorFactory.makeSurviveRuleBehavior(neighbors);
    }
}
