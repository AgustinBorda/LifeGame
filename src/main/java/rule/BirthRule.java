package rule;

import rule.behavior.RuleBehaviorFactory;

public class BirthRule extends Rule {
    public BirthRule(int neighbors) {
        behavior = RuleBehaviorFactory.makeBirthRuleBehavior(neighbors);
    }
}
