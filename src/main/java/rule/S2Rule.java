package rule;

import rule.behavior.S2RuleBehavior;

public class S2Rule extends Rule {
    public S2Rule() {
        behavior = new S2RuleBehavior();
    }
}
