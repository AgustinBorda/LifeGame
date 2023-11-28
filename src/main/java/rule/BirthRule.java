package rule;

import rule.behavior.RuleBehaviorFactory;

public class BirthRule extends Rule {
    public BirthRule(int neighbors) {
        behavior = RuleBehaviorFactory.makeBirthRuleBehavior(neighbors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BirthRule)
            return behavior.equals(((BirthRule) obj).behavior);
        return false;
    }
}
