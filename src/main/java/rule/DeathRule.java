package rule;

import rule.behavior.DeathRuleBehavior;

public class DeathRule extends Rule{
    public DeathRule() {
        behavior = new DeathRuleBehavior();
    }
}
