package rule;

import rule.behavior.S3RuleBehavior;

public class S3Rule extends Rule {
    public S3Rule() {
        behavior = new S3RuleBehavior();
    }
}
