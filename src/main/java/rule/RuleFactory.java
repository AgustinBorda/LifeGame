package rule;

import java.util.ArrayList;
import java.util.List;

public class RuleFactory {
    public static Rule createDeathRule() {
        return new DeathRule();
    }

    public static Rule createBirthRule(int neighbors) {
        if(neighbors < 0 || neighbors > 8)
            throw new IllegalArgumentException("Invalid neighbors number");
        return new BirthRule(neighbors);
    }

    public static Rule createSurviveRule(int neighbors) {
        if(neighbors < 0 || neighbors > 8)
            throw new IllegalArgumentException("Invalid neighbors number");
        return new SurviveRule(neighbors);
    }

    public static List<Rule> createRules(RuleList rules) {
        List<Rule> result = new ArrayList<>();
        for(Integer i : rules.getBirthList()) {
            result.add(createBirthRule(i));
        }
        for(Integer i : rules.getSurviveList()) {
            result.add(createSurviveRule(i));
        }
        result.add(createDeathRule());
        return result;
    }
}