package rule;

import rule.behavior.B3RuleBehavior;

public class B3Rule extends Rule {
    public B3Rule() {
        behavior = new B3RuleBehavior();
    }
}
