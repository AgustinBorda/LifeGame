package ruleapplicator;

import board.Board;
import board.BoardIterator;
import cell.Cell;
import rule.DeathRule;
import rule.Rule;
import rule.RuleFactory;

import java.util.ArrayList;
import java.util.List;

public class RuleApplicator {
    List<Rule> rules;  //rules = [DeathRule, otherRules]

    Board b;

    public RuleApplicator(Board b, List<Rule> r) {
        this.b = b;
        rules = new ArrayList<>();
        rules.add(RuleFactory.createDeathRule());
        rules.addAll(r);
    }

    public void applyRules() {
        for(Rule r: rules) {
            BoardIterator boardIterator = b.iterator();
            while (boardIterator.hasNext()) {
                Cell c = boardIterator.next();
                if(r.canApply(c))
                    r.apply(c);
            }
            b.transition();
        }

    }
}
